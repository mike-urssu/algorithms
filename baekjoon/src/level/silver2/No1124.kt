package level.silver2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

/**
 * https://www.acmicpc.net/problem/1124
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private const val SIZE = 100000

private val isPrime = BooleanArray(SIZE + 1) { true }
private val countsOfPrime = IntArray(SIZE + 1)
private val isUnderPrime = BooleanArray(SIZE + 1)

fun main() {
    val (a, b) = reader.readLine().split(" ").map { it.toInt() }
    setPrime()
    setCountsOfPrime()
    setUnderPrime()
    writer.write("${countUnderPrime(a, b)}")
    writer.flush()
}

private fun setPrime() {
    isPrime[0] = false
    isPrime[1] = false
    for (i in 2 until sqrt(SIZE.toDouble()).toInt()) {
        for (j in i * i..SIZE step i) {
            isPrime[j] = false
        }
    }
}

private fun setCountsOfPrime() {
    for (i in 2..SIZE) {
        if (isPrime[i]) {
            countsOfPrime[i] = 1
        } else {
            for (j in 2..sqrt(i.toDouble()).toInt()) {
                if (i % j == 0) {
                    countsOfPrime[i] = countsOfPrime[i / j] + 1
                    break
                }
            }
        }
    }
}

private fun setUnderPrime() {
    for (i in 2..SIZE) {
        isUnderPrime[i] = isPrime[countsOfPrime[i]]
    }
}

private fun countUnderPrime(from: Int, to: Int): Int {
    var count = 0
    for (i in from..to) {
        if (isUnderPrime[i]) {
            count++
        }
    }
    return count
}
