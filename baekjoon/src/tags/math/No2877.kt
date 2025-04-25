package tags.math

/**
 * https://www.acmicpc.net/problem/2877
 */
fun main() {
    val k = readln().toInt()

    val l = getLength(k)
    val dec = (0 until l).sumOf { i -> 1 shl i }
    var remainder = k + 1 - dec

    val digits = (0 until l).map { i ->
        val half = 1 shl (l - i - 1)
        if (remainder in 0..half) {
            4
        } else {
            remainder -= half
            7
        }
    }

    println(digits.joinToString(""))
}

private fun getLength(k: Int): Int {
    var i = 1
    var prefixSum = 0
    while (prefixSum < k) {
        prefixSum += 1 shl i++
    }
    return i - 1
}
