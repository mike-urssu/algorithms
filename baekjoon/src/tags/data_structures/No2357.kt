package tags.data_structures

/**
 * https://www.acmicpc.net/problem/2357
 */
import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))
private lateinit var numbers: IntArray
private lateinit var maxTree: IntArray
private lateinit var minTree: IntArray

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    numbers = IntArray(n + 1)
    repeat(n) { i -> numbers[i + 1] = reader.readLine().toInt() }

    maxTree = IntArray(n * 4) { Int.MIN_VALUE }
    minTree = IntArray(n * 4) { Int.MAX_VALUE }
    init(1, 0, n)

    repeat(m) {
        val (a, b) = reader.readLine().split(" ").map { it.toInt() }
        println("${getMin(1, 0, n, a, b)} ${getMax(1, 0, n, a, b)}")
    }
}

private fun init(node: Int, low: Int, high: Int) {
    if (low == high) {
        maxTree[node] = numbers[low]
        minTree[node] = numbers[low]
        return
    }

    val mid = (low + high) / 2
    init(node * 2, low, mid)
    init(node * 2 + 1, mid + 1, high)
    maxTree[node] = maxTree[node * 2].coerceAtLeast(maxTree[node * 2 + 1])
    minTree[node] = minTree[node * 2].coerceAtMost(minTree[node * 2 + 1])
}

private fun getMax(node: Int, low: Int, high: Int, a: Int, b: Int): Int {
    if (b < low || high < a) {
        return Int.MIN_VALUE
    }

    if (a <= low && high <= b) {
        return maxTree[node]
    }

    val mid = (low + high) / 2
    val leftMax = getMax(node * 2, low, mid, a, b)
    val rightMax = getMax(node * 2 + 1, mid + 1, high, a, b)
    return maxOf(leftMax, rightMax)
}


private fun getMin(node: Int, low: Int, high: Int, a: Int, b: Int): Int {
    if (b < low || high < a) {
        return Int.MAX_VALUE
    }

    if (a <= low && high <= b) {
        return minTree[node]
    }

    val mid = (low + high) / 2
    val leftMin = getMin(node * 2, low, mid, a, b)
    val rightMin = getMin(node * 2 + 1, mid + 1, high, a, b)
    return minOf(leftMin, rightMin)
}
