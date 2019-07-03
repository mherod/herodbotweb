package dev.herod.monzo

import kotlinx.serialization.json.Json
import kotlinx.serialization.parse
import org.junit.Assert.assertEquals
import org.junit.Test

class MonzoTransactionWebhookTest {

    @Test
    fun parseSampleWebhook() {
        val webhookJson = javaClass.getResource("samplewebhook.json").readText()
        val webhook = Json.parse<MonzoTransactionWebhook>(webhookJson)
        val type = webhook.type
        assertEquals(type, "transaction.created")
        val data = webhook.data
        assertEquals(data.description, "Ozone Coffee Roasters")
        val address = data.merchant.address
        assertEquals(address.city, "London")
        assertEquals(address.country, "GB")
    }
}
