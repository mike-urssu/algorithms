package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2670
 */
fun main() {
    val n = readln().toInt()
    val numbers = DoubleArray(n) { readln().toDouble() }
    println(String.format("%.3f", getMax(numbers)))
}

private fun getMax(numbers: DoubleArray): Double {
    var max = Double.MIN_VALUE
    for (i in numbers.indices) {
        var mul = 1.0
        for (j in i until numbers.size) {
            mul *= numbers[j]
            max = max.coerceAtLeast(mul)
        }
    }
    return max
}
