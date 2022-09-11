package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

/**
 * https://www.acmicpc.net/problem/1929
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val primeArray = getPrimeArray()

    val numbers = reader.readLine().split(" ").map { it.toInt() }
    for (number in numbers[0]..numbers[1]) {
        if (primeArray[number])
            writer.write("$number\n")
    }
    writer.flush()
}

private fun getPrimeArray(): BooleanArray {
    val size = 1000001
    val primeArray = BooleanArray(size) { true }
    primeArray[0] = false
    primeArray[1] = false

    val sqrt = sqrt(size.toDouble()).toInt()
    for (i in 2..sqrt) {
        for (j in i * i until size step i) {
            primeArray[j] = false
        }
    }

    return primeArray
}