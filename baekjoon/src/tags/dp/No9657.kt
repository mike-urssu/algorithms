package tags.dp

/**
 * https://www.acmicpc.net/problem/9657
 */
fun main() {
    val n = readln().toInt()
    if (getWinners()[n]) {
        println("SK")
    } else {
        println("CY")
    }
}

private fun getWinners(): BooleanArray {
    val winners = BooleanArray(1001)
    winners[0] = true
    winners[1] = true
    winners[3] = true
    winners[4] = true
    (5..1000).forEach { i -> winners[i] = !(winners[i - 4] && winners[i - 3] && winners[i - 1]) }
    return winners
}
