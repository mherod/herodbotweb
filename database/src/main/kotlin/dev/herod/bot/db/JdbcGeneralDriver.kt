package dev.herod.bot.db

import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlCursor
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.db.SqlPreparedStatement
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Types

class JdbcGeneralDriver constructor(private val connection: Connection) : SqlDriver {

    private val transactions = ThreadLocal<Transacter.Transaction>()

    override fun close() = connection.close()

    override fun execute(
        identifier: Int?,
        sql: String,
        parameters: Int,
        binders: (SqlPreparedStatement.() -> Unit)?
    ) {
        MyPreparedStatement(connection.prepareStatement(sql))
            .apply { if (binders != null) this.binders() }
            .execute()
    }

    override fun executeQuery(
        identifier: Int?,
        sql: String,
        parameters: Int,
        binders: (SqlPreparedStatement.() -> Unit)?
    ): SqlCursor {
        return MyPreparedStatement(connection.prepareStatement(sql))
            .apply { if (binders != null) this.binders() }
            .executeQuery()
    }

    override fun newTransaction(): Transacter.Transaction {
        val enclosing = transactions.get()
        val transaction = Transaction(enclosing)
        transactions.set(transaction)

        if (enclosing == null) {
            connection.prepareStatement("BEGIN TRANSACTION").execute()
        }

        return transaction
    }

    override fun currentTransaction(): Transacter.Transaction? = transactions.get()

    private inner class Transaction(
        override val enclosingTransaction: Transacter.Transaction?
    ) : Transacter.Transaction() {
        override fun endTransaction(successful: Boolean) {
            if (enclosingTransaction == null) {
                if (successful) {
                    connection.prepareStatement("END TRANSACTION").execute()
                } else {
                    connection.prepareStatement("ROLLBACK TRANSACTION").execute()
                }
            }
            transactions.set(enclosingTransaction)
        }
    }

    private class MyPreparedStatement(
        private val preparedStatement: PreparedStatement
    ) : SqlPreparedStatement {
        override fun bindBytes(index: Int, value: ByteArray?) {
            if (value == null) {
                preparedStatement.setNull(index, Types.BLOB)
            } else {
                preparedStatement.setBytes(index, value)
            }
        }

        override fun bindLong(index: Int, value: Long?) {
            if (value == null) {
                preparedStatement.setNull(index, Types.INTEGER)
            } else {
                preparedStatement.setLong(index, value)
            }
        }

        override fun bindDouble(index: Int, value: Double?) {
            if (value == null) {
                preparedStatement.setNull(index, Types.REAL)
            } else {
                preparedStatement.setDouble(index, value)
            }
        }

        override fun bindString(index: Int, value: String?) {
            if (value == null) {
                preparedStatement.setNull(index, Types.VARCHAR)
            } else {
                preparedStatement.setString(index, value)
            }
        }

        internal fun executeQuery() = MyJdbcCursor(preparedStatement.executeQuery())

        internal fun execute() {
            preparedStatement.execute()
        }
    }

    private class MyJdbcCursor(
        private val resultSet: ResultSet
    ) : SqlCursor {
        override fun getString(index: Int): String? = resultSet.getString(index + 1)
        override fun getBytes(index: Int): ByteArray? = resultSet.getBytes(index + 1)
        override fun getLong(index: Int): Long? {
            val value = resultSet.getLong(index + 1)
            if (resultSet.wasNull()) return null
            return value
        }

        override fun getDouble(index: Int): Double? {
            val value = resultSet.getDouble(index + 1)
            if (resultSet.wasNull()) return null
            return value
        }

        override fun close() = resultSet.close()
        override fun next() = resultSet.next()
    }
}
