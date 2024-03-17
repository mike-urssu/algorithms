package tags.data_structures

/**
 * https://www.acmicpc.net/problem/13335
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, w, l) = readln().split(" ").map { it.toInt() }
    val weights = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getMinimumTime(n, w, l, weights))
}

private fun getMinimumTime(n: Int, w: Int, l: Int, weights: IntArray): Int {
    val queue: Queue<Int> = LinkedList()
    queue.add(weights[0])

    var time = 1
    var currentWeight = weights[0]
    var index = 1

    while (index < n && queue.isNotEmpty()) {
        if (queue.size == w) {
            currentWeight -= queue.poll()
        }

        if (currentWeight + weights[index] > l) {
            queue.add(0)
        } else {
            currentWeight += weights[index]
            queue.add(weights[index])
            index++
        }
        time++
    }

    return time + w
}
