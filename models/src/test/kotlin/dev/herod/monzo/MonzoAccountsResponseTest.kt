package dev.herod.monzo

import kotlinx.serialization.json.Json
import kotlinx.serialization.parse
import org.junit.Assert.assertEquals
import org.junit.Test

class MonzoAccountsResponseTest {

    @Test
    fun parseSampleWebhook() {
        val accountsJson = javaClass.getResource("sampleaccounts.json").readText()
        val accountsResponse = Json.parse<MonzoAccountsResponse>(accountsJson)
        val accounts = accountsResponse.accounts
        val account = accounts.first()
        assertEquals(account.id, "acc_0ZZZzzz10Op79zzz1fTNeD")
    }
}
