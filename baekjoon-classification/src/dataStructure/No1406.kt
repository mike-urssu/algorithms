package dataStructure

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/1406
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val front = LinkedList<Char>()
    val back = LinkedList<Char>()

    reader.readLine().forEach { front.addLast(it) }

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val commands = reader.readLine().split(" ")
        when (commands[0]) {
            "L" -> if (front.isNotEmpty()) back.addFirst(front.pollLast())
            "D" -> if (back.isNotEmpty()) front.addLast(back.pollFirst())
            "B" -> if (front.isNotEmpty()) front.pollLast()
            "P" -> front.addLast(commands[1][0])
        }
    }

    while (front.isNotEmpty())
        writer.write("${front.pollFirst()}")
    while (back.isNotEmpty())
        writer.write("${back.pollFirst()}")
    writer.flush()
}
