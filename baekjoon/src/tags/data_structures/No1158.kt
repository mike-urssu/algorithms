package tags.data_structures

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

/**
 * https://www.acmicpc.net/problem/1158
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val queue = LinkedList<Int>()

    val numbers = reader.readLine().split(" ").map { it.toInt() }
    for (i in 1..numbers[0])
        queue.add(i)

    val josephus = IntArray(numbers[0])
    var index = 0
    while (queue.isNotEmpty()) {
        repeat(numbers[1] - 1) {
            queue.add(queue.pop())
        }
        josephus[index++] = queue.pop()
    }

    writer.write(josephus.joinToString(", ", "<", ">"))
    writer.flush()
}
