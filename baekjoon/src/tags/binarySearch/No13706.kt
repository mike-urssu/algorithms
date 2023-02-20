package tags.binarySearch

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

/**
 * https://www.acmicpc.net/problem/13706
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toBigInteger()

    var low = BigInteger.ZERO
    var high = BigInteger("9".repeat(800))
    while (low.plus(BigInteger.ONE) < high) {
        val mid = low.plus(high).divide(BigInteger.valueOf(2))
        val pow = mid.pow(2)
        if (pow > number) {
            high = mid
        } else {
            low = mid
        }
    }

    writer.write("$low")
    writer.flush()
}
