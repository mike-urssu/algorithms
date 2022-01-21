package greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/16953
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numbers = reader.readLine().split(' ').map { it.toLong() }
    writer.write(getChangedCount(numbers[0], numbers[1]).toString())
    writer.flush()
}

fun getChangedCount(source: Long, target: Long): Long {
    val queue = LinkedList<LongArray>()
    queue.add(longArrayOf(source, 1))

    while (!queue.isEmpty()) {
        val array = queue.poll()
        if (array[0] == target)
            return array[1]

        if (array[0] * 2 <= target)
            queue.add(longArrayOf(array[0] * 2, array[1] + 1))
        if (array[0] * 10 + 1 <= target)
            queue.add(longArrayOf(array[0] * 10 + 1, array[1] + 1))
    }
    return -1
}
