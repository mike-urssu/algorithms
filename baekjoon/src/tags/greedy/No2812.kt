package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/2812
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val input = reader.readLine().split(' ')
    var countToErase = input[1].toInt()

    val queue = LinkedList<Char>()
    val numbersInCharacter = reader.readLine().toCharArray()
    for (number in numbersInCharacter) {
        while (countToErase > 0 && !queue.isEmpty() && queue.peekLast() < number) {
            queue.pollLast()
            countToErase--
        }
        queue.addLast(number)
    }
    while (countToErase-- > 0)
        queue.pollLast()

    while (!queue.isEmpty())
        writer.write(queue.pollFirst().toString())
    writer.flush()
}
