package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2609
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    val gcd = getGCD(numbers[0], numbers[1])
    val lcm = numbers[0] / gcd * numbers[1]

    writer.write("$gcd\n$lcm")
    writer.flush()
}

private fun getGCD(number1: Int, number2: Int): Int {
    if (number2 == 0)
        return number1
    return getGCD(number2, number1 % number2)
}