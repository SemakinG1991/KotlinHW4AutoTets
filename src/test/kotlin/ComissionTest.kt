import org.junit.Test
import kotlin.test.assertEquals

class ComissionTest {

    @Test
    fun testMasterMaestroFree() {
        val card = "Mastercard"
        val earlytranfer = 10_000
        val transfer = 0

        val result = calcComission(card, earlytranfer, transfer)
        assertEquals(0, result)
    }
    @Test
    fun testMasterMaestroComission() {
        val card = "Mastercard"
        val earlytranfer = 0
        val transfer = 80_000

        val result = calcComission(card, earlytranfer, transfer)
        assertEquals(500, result)
    }
    @Test
    fun testMasterMaestroWrong() {
        val card = "MasterCard"
        val earlytranfer = 10_000
        val transfer = 0

        val result = calcComission(card, earlytranfer, transfer)
        assertEquals(ERROR_CARD, result)
    }
    @Test
    fun testMasterMaestroDailyLimits() {
        val card = "Mastercard"
        val earlytranfer = 0
        val transfer = 160_000
        val result = calcComission(card, earlytranfer, transfer)
        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun testMasterMaestroMonthlyLimits() {
        val card = "Mastercard"
        val earlytranfer = 610_000
        val transfer = 80_000
        val result = calcComission(card, earlytranfer, transfer)
        assertEquals(ERROR_LIMIT, result)
    }
    //VISA
    @Test
    fun testVisaMirDailyLimits() {
        val card = "Visa"
        val earlytranfer = 0
        val transfer = 160_000
        val result = calcComission(card, earlytranfer, transfer)
        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun testVisaMirMonthlyLimits() {
        val card = "Visa"
        val earlytranfer = 615_000
        val transfer = 10_000
        val result = calcComission(card, earlytranfer, transfer)
        assertEquals(ERROR_LIMIT, result)
    }


}