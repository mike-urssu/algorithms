package tags.dp

/**
 * https://www.acmicpc.net/problem/1516
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var times: IntArray
private lateinit var degrees: IntArray
private lateinit var previousOrders: Array<MutableList<Int>>

fun main() {
    val n = readln().toInt()
    times = IntArray(n + 1)
    degrees = IntArray(n + 1)
    previousOrders = Array(n + 1) { mutableListOf() }

    for (i in 1..n) {
        val input = readln().split(" ").map { it.toInt() }.dropLast(1)
        times[i] = input[0]
        for (j in 1 until input.size) {
            previousOrders[input[j]].add(i)
            degrees[i]++
        }
    }

    val prefixSum = getPrefixSum(n)
    (1..n).forEach { i -> println(prefixSum[i]) }
}

private fun getPrefixSum(n: Int): IntArray {
    val prefixSum = IntArray(n + 1)
    val queue = LinkedList<Int>() as Queue<Int>

    (1..n).forEach { i ->
        if (degrees[i] == 0) {
            queue.add(i)
        }
    }

    while (queue.isNotEmpty()) {
        val i = queue.poll()
        for (j in previousOrders[i]) {
            prefixSum[j] = prefixSum[j].coerceAtLeast(prefixSum[i] + times[i])
            degrees[j]--
            if (degrees[j] == 0) {
                queue.add(j)
            }
        }
    }

    (1..n).forEach { i -> prefixSum[i] += times[i] }
    return prefixSum
}
