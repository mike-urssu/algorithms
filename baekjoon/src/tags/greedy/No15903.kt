package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/15903
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val input = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
    var countToSum = input[1]

    val queue = PriorityQueue<Long>()
    reader.readLine().split(' ').map { it -> queue.add(it.toLong()) }

    while (countToSum-- > 0) {
        val x = queue.poll()
        val y = queue.poll()
        val sum = x + y
        queue.add(sum)
        queue.add(sum)
    }

    var sum = 0L
    while (!queue.isEmpty())
        sum += queue.poll()
    writer.write(sum.toString())
    writer.flush()
}
