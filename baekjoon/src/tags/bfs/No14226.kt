package tags.bfs

/**
 * https://www.acmicpc.net/problem/14226
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val s = readln().toInt()
    println(getLeastTime(s))
}

private fun getLeastTime(s: Int): Int {
    val times = IntArray(1001) { Int.MAX_VALUE }
    val queue: Queue<IntArray> = LinkedList()

    times[1] = 0
    queue.add(intArrayOf(1, 1, 0, 1))

    while (queue.isNotEmpty()) {
        val peek = queue.peek()
        val (length, _, command, time) = queue.poll()
        if (length == s && times[length] > time) {
            times[length] = times[length].coerceAtMost(time)
            continue
        }

        when (command) {
            0 -> {
                paste(queue, times, peek)
            }

            1 -> {
                copy(queue, peek)
                paste(queue, times, peek)
                delete(queue, times, peek)
            }

            2 -> {
                copy(queue, peek)
                paste(queue, times, peek)
                delete(queue, times, peek)
            }
        }
    }

    return times[s]
}

private fun copy(queue: Queue<IntArray>, input: IntArray) {
    val (length, _, _, time) = input
    if (length + length <= 1000) {
        queue.add(intArrayOf(length, length, 0, time + 1))
    }
}

private fun paste(queue: Queue<IntArray>, times: IntArray, input: IntArray) {
    val (length, copiedLength, _, time) = input
    if (length + copiedLength <= 1000) {
        times[length + copiedLength] = times[length + copiedLength].coerceAtMost(time + 1)
        queue.add(intArrayOf(length + copiedLength, copiedLength, 1, time + 1))
    }
}

private fun delete(queue: Queue<IntArray>, times: IntArray, input: IntArray) {
    val (length, copiedLength, _, time) = input
    if (length >= 4 && times[length - 1] > time + 1) {
        times[length - 1] = time + 1
        queue.add(intArrayOf(length - 1, copiedLength, 2, time + 1))
    }
}
