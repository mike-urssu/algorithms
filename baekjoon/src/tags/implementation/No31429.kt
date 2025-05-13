package tags.implementation

/**
 * https://www.acmicpc.net/problem/31429
 */
fun main() {
    val n = readln().toInt()
    val output = when (n) {
        1 -> "12 1600"
        2 -> "11 894"
        3 -> "11 1327"
        4 -> "10 1311"
        5 -> "9 1004"
        6 -> "9 1178"
        7 -> "9 1357"
        8 -> "8 837"
        9 -> "7 1055"
        10 -> "6 556"
        else -> "6 773"
    }
    println(output)
}
