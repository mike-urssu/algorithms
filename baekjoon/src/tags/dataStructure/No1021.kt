package tags.dataStructure

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/1021
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val deque = LinkedList<Int>()

    val inputs = reader.readLine().split(" ").map { it.toInt() }
    for (i in 1..inputs[0])
        deque.addLast(i)
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    var count = 0
    for (number in numbers) {
        if (deque.size / 2 >= deque.indexOf(number)) {
            while (deque.peekFirst() != number) {
                deque.addLast(deque.pollFirst())
                count++
            }
        } else {
            while (deque.peekFirst() != number) {
                deque.addFirst(deque.pollLast())
                count++
            }
        }
        deque.pollFirst()
    }
    writer.write("$count")
    writer.flush()
}
