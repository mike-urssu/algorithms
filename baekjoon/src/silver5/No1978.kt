package silver5

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

private lateinit var isPrime: BooleanArray

fun main() {
    setIsPrime()

    reader.readLine()
    val primes = reader.readLine().split(" ").map { it.toInt() }
        .count { isPrime[it] }

    writer.write("$primes")
    writer.flush()
}

private fun setIsPrime() {
    isPrime = BooleanArray(1001) { true }
    isPrime[0] = false
    isPrime[1] = false
    for (i in 2..sqrt(1001.0).toInt()) {
        for (j in i * i..1000 step i) {
            isPrime[j] = false
        }
    }
}