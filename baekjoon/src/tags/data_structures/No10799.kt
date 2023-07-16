package tags.data_structures

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/10799
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val stack = Stack<Char>()

    val parentheses = reader.readLine()
    var sum = 0
    for (i in parentheses.indices) {
        if (parentheses[i] == '(')
            stack.push(parentheses[i])
        else {
            stack.pop()
            sum += if (parentheses[i - 1] == '(') stack.size else 1
        }
    }
    writer.write("$sum")
    writer.flush()
}
