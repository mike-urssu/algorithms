package tags.binarySearch

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

/**
 * https://www.acmicpc.net/problem/2417
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toBigInteger()

    var low = BigInteger.valueOf(-1L)
    var high = BigInteger.valueOf(Long.MAX_VALUE)
    while (low.plus(BigInteger.ONE) < high) {
        val mid = (low + high).divide(BigInteger.valueOf(2))
        if (mid.pow(2) >= number) {
            high = mid
        } else {
            low = mid
        }
    }
    writer.write("$high")
    writer.flush()
}
