package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

/**
 * https://www.acmicpc.net/problem/8437
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val sum = reader.readLine().toBigInteger()
    val diff = reader.readLine().toBigInteger()

    writer.write("${sum.minus(diff).divide(BigInteger.valueOf(2)).plus(diff)}\n")
    writer.write("${sum.minus(diff).divide(BigInteger.valueOf(2))}")
    writer.flush()
}