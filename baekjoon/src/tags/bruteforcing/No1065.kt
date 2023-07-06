package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1065
 */
fun main() {
    val n = readln().toInt()
    val count = (1..n).count { isArithmeticSequence(it) }
    println(count)
}

private fun isArithmeticSequence(n: Int): Boolean {
    if (n >= 100) {
        val digits = n.toString()
        val diff = digits[0].digitToInt() - digits[1].digitToInt()
        for (i in 0 until digits.length - 1) {
            if (digits[i] - digits[i + 1] != diff) {
                return false
            }
        }
    }
    return true
}
