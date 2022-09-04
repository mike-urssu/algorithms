package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/17466
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val number = numbers[0]
    val mod = numbers[1]
    writer.write("${getModFactorial(number, mod)}")
    writer.flush()
}

private fun getModFactorial(number: Int, mod: Int): Long {
    var factorial = 1L
    var mul = 1
    while (mul <= number) {
        factorial = factorial * mul % mod
        mul++
    }
    return factorial
}