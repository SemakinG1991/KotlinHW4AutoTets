import org.junit.Test
import kotlin.test.assertEquals

class ComissionTest {

    @Test
    fun testMasterMaestroFree() {
        val typecard = "Mastercard"
        val earlytranfer = 10_000
        val transfer = 0

        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(0, result)
    }
    @Test
    fun testMasterMaestroComission() {
        val typecard = "Maestro"
        val earlytranfer = 0
        val transfer = 80_000

        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(500, result)
    }
    @Test
    fun testMasterWrong() {
        val typecard = "MasterCard"
        val earlytranfer = 10_000
        val transfer = 0

        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(ERROR_CARD, result)
    }
    @Test
    fun testMaestroWrong() {
        val typecard = "Maestra"
        val earlytranfer = 10_000
        val transfer = 0

        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(ERROR_CARD, result)
    }
    @Test
    fun testMasterMaestroDailyLimits() {
        val typecard = "Mastercard"
        val earlytranfer = 0
        val transfer = 160_000
        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun testMasterMaestroMonthlyLimits() {
        val typecard = "Maestro"
        val earlytranfer = 610_000
        val transfer = 80_000
        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(ERROR_LIMIT, result)
    }
    //VISA

    @Test
    fun testVisaWrong() {
        val typecard = "Vissa"
        val earlytranfer = 10_000
        val transfer = 0

        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(ERROR_CARD, result)
    }
    @Test
    fun testMirWrong() {
        val typecard = "Mirr"
        val earlytranfer = 10_000
        val transfer = 0

        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(ERROR_CARD, result)
    }
    @Test
    fun testVisaMirDailyLimits() {
        val typecard = "Visa"
        val earlytranfer = 0
        val transfer = 160_000
        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun testVisaMirMonthlyLimits() {
        val typecard = "Mir"
        val earlytranfer = 615_000        //615000
        val transfer = 10_000
        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun testVisaMirComission() {
        val typecard = "Visa"
        val earlytranfer = 0
        val transfer = 10_000

        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(75, result)   //75
    }
    @Test
    fun testVisaMirFixComission() {
        val typecard = "Visa"
        val earlytranfer = 0
        val transfer = 2_000

        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(35, result)  //35
    }

    //VK
    @Test
    fun testVKPayDailyLimits() {
        val typecard = "VK Pay"
        val earlytranfer = 0
        val transfer = 16_000
        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun testVKPayMonthlyLimits() {
        val typecard = "VK Pay"
        val earlytranfer = 40_000
        val transfer = 1_000
        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun testVKPayFree() {
        val typecard = "VK Pay"
        val earlytranfer = 10_000
        val transfer = 1000

        val result = calcComission(typecard, earlytranfer, transfer)
        assertEquals(0, result)
    }

}