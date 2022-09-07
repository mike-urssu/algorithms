package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

/**
 * https://www.acmicpc.net/problem/4948
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val primeArray = getPrimeArray()

    while (true) {
        val number = reader.readLine().toInt()
        if (number == 0)
            break
        writer.write("${countPrimes(primeArray, number)}\n")
    }
    writer.flush()
}

private fun getPrimeArray(): BooleanArray {
    val size = 123456 * 2 + 1
    val primeArray = BooleanArray(size) { true }
    primeArray[0] = false
    primeArray[1] = false

    val sqrt = sqrt(size.toDouble()).toInt()
    for (i in 2..sqrt) {
        for (j in i * i..size step i) {
            primeArray[j] = false
        }
    }

    return primeArray
}

private fun countPrimes(primeArray: BooleanArray, number: Int): Int {
    var count = 0

    for (i in number + 1..number * 2) {
        if (primeArray[i])
            count++
    }

    return count
}