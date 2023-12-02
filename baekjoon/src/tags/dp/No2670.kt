package tags.dp

/**
 * https://www.acmicpc.net/problem/2670
 */
fun main() {
    val n = readln().toInt()
    val doubles = DoubleArray(n) { readln().toDouble() }
    println(String.format("%.3f", getMax(n, doubles)))
}

private fun getMax(n: Int, doubles: DoubleArray): Double {
    val prefixMultiple = DoubleArray(n + 1)
    prefixMultiple[0] = 1.0
    (1..n).forEach { i ->
        prefixMultiple[i] = maxOf(prefixMultiple[i - 1] * doubles[i - 1], doubles[i - 1])
    }
    return (1..n).maxOf { prefixMultiple[it] }
}
