package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2581
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var isPrime: BooleanArray

fun main() {
    setPrime()

    val m = reader.readLine().toInt()
    val n = reader.readLine().toInt()

    var min = Int.MAX_VALUE
    var sum = 0
    for (i in m..n) {
        if (isPrime[i]) {
            min = min.coerceAtMost(i)
            sum += i
        }
    }

    if (sum == 0) {
        writer.write("-1")
    } else {
        writer.write("$sum\n")
        writer.write("$min")
    }
    writer.flush()
}

private fun setPrime() {
    isPrime = BooleanArray(10001) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..100) {
        for (j in i * i..10000 step i) {
            isPrime[j] = false
        }
    }
}