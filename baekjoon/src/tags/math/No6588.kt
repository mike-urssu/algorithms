package tags.math

/**
 * https://www.acmicpc.net/problem/6588
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))
private val isPrime = getPrimes()

fun main() {
    while (true) {
        val n = reader.readLine().toInt()
        if (n == 0) {
            break
        }

        if (n % 2 == 1) {
            writer.write("Goldbach's conjecture is wrong.\n")
        } else {
            val (a, b) = find(n)
            writer.write("$n = $a + $b\n")
        }
    }
    writer.flush()
}

private fun getPrimes(): BooleanArray {
    val isPrime = BooleanArray(1000001) { true }
    isPrime[0] = false
    isPrime[1] = false
    for (i in 2..1000) {
        for (j in i * i..1000000 step i) {
            isPrime[j] = false
        }
    }
    return isPrime
}

private fun find(n: Int): List<Int> {
    val a = (3..n / 2).find { i -> isPrime[i] && isPrime[n - i] }!!
    return listOf(a, n - a)
}
