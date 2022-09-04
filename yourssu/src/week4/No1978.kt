package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

/**
 * https://www.acmicpc.net/problem/1978
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val primeArray = getPrimeArray()

    var primeCount = 0
    reader.readLine()
    reader.readLine().split(" ").map { it.toInt() }
        .forEach { if (primeArray[it]) primeCount++ }

    writer.write("$primeCount")
    writer.flush()
}

private fun getPrimeArray(): BooleanArray {
    val size = 1001
    val isPrime = BooleanArray(size) { true }
    isPrime[0] = false
    isPrime[1] = false

    val sqrt = sqrt(size.toDouble()).toInt()

    for (i in 2..sqrt) {
        for (j in i * i until size step i) {
            isPrime[j] = false
        }
    }

    return isPrime
}