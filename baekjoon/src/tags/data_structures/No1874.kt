package tags.data_structures

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

/**
 * https://www.acmicpc.net/problem/1874
 */
private val stack = Stack<Int>()
private val pushOrPops = arrayListOf<Char>()

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val numbers = IntArray(numberOfInput) { reader.readLine().toInt() }

    var maxNumber = 0
    for (number in numbers) {
        if (maxNumber < number) {
            for (i in maxNumber + 1..number)
                push(i)
            maxNumber = number
        } else {
            if (stack.peek() != number)
                break
        }
        pop()
    }

    if (stack.isEmpty()) {
        for (pushOrPop in pushOrPops) {
            writer.write("$pushOrPop")
            writer.newLine()
        }
    } else
        writer.write("NO")
    writer.flush()
}

private fun push(number: Int) {
    stack.push(number)
    pushOrPops.add('+')
}

private fun pop() {
    stack.pop()
    pushOrPops.add('-')
}
