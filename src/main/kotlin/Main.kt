const val ERROR_CARD = -1
const val ERROR_LIMIT = -2

fun main(args: Array<String>) {
    println(calcComission("Mastercard", 20_000, transfer = 70_000))
}

fun calcComission(typeCard: String , earlyTransfer: Int , transfer: Int) : Int {
    return when (typeCard) {
        "Mastercard", "Maestro" -> when {
            transfer > 150_000 || earlyTransfer + transfer > 600_000 -> ERROR_LIMIT
            earlyTransfer + transfer < 75_000 -> 0
            else -> (transfer * 0.006 + 20).toInt()
        }

        "Visa", "Mir" -> when {
            transfer > 150_000 || earlyTransfer + transfer > 600_000 -> ERROR_LIMIT
            transfer * 0.0075 < 35 -> 35
            else -> (transfer * 0.0075).toInt()
        }

        "VK Pay" -> when {
            transfer > 15_000 || earlyTransfer + transfer > 40_000 -> ERROR_LIMIT
            else -> 0
        }
        else -> ERROR_CARD
    }
}


