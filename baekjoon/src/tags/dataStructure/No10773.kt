package tags.dataStructure

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/10773
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val stack = Stack<Int>()

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val number = reader.readLine().toInt()
        if (number == 0)
            stack.pop()
        else
            stack.push(number)
    }

    var sum = 0
    while (!stack.isEmpty())
        sum += stack.pop()
    writer.write("$sum")
    writer.flush()
}
