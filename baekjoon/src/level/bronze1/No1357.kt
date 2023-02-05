package level.bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1357
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (number1, number2) = reader.readLine().split(" ")
    writer.write("${rev((rev(number1) + rev(number2)))}")
    writer.flush()
}

private fun rev(x: String) = x.reversed().toInt()

private fun rev(x: Int) = rev(x.toString())
