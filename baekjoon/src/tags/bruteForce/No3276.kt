package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/3276
 */
fun main() {
    val n = readln().toInt()

    var rowAndCol = IntArray(2)
    var sum = Int.MAX_VALUE

    for (row in 1..n) {
        val col = if (n % row == 0) {
            n / row
        } else {
            n / row + 1
        }

        if (sum > row + col) {
            sum = row + col
            rowAndCol = intArrayOf(row, col)
        }
    }

    println(rowAndCol.joinToString(" "))
}
