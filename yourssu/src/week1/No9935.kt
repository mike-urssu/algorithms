package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

/**
 * https://www.acmicpc.net/problem/9935
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val givenWord = reader.readLine()
    val bomb = reader.readLine()

    val stack = Stack<Char>()
    for (index in givenWord.indices) {
        stack.push(givenWord[index])

        if (stack.size >= bomb.length && bomb[bomb.lastIndex] == givenWord[index]) {
            val charactersFromStack = StringBuilder()
            for (i in bomb.indices)
                charactersFromStack.append(stack.pop())

            if (bomb != charactersFromStack.reversed().toString())
                charactersFromStack.reversed().forEach { stack.push(it) }
        }
    }

    val remainder = StringBuilder()
    while (!stack.isEmpty())
        remainder.append(stack.pop())

    writer.write(if (remainder.isEmpty()) "FRULA" else remainder.reversed().toString())
    writer.flush()
}