package tags.sorting

/**
 * https://www.acmicpc.net/problem/2212
 */
private var n = 0
private var k = 0
private lateinit var numbers: IntArray

fun main() {
    n = readln().toInt()
    k = readln().toInt()
    numbers = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    println(getMinimumSumOfDistances(n, k, numbers))
}

private fun getMinimumSumOfDistances(n: Int, k: Int, numbers: IntArray): Int {
    val distancesBetweenSensors = IntArray(n - 1) { i -> numbers[i + 1] - numbers[i] }.sorted()
    return distancesBetweenSensors.dropLast(k - 1).sum()
}
