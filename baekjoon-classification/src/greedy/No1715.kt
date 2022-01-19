package greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/1715
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val queue = PriorityQueue<Int>()
    for (i in 0 until numberOfInput)
        queue.add(reader.readLine().toInt())

    var sum = 0
    while (queue.size > 1) {
        val n1 = queue.poll()
        val n2 = queue.poll()
        queue.add(n1 + n2)
        sum += n1 + n2
    }

    writer.write(sum.toString())
    writer.flush()
}
