package bronze3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

/**
 * https://www.acmicpc.net/problem/1247
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    repeat(3) {
        var sum = BigInteger.ZERO

        val numberOfInput = reader.readLine().toInt()
        repeat(numberOfInput) {
            val number = reader.readLine()
            sum = sum.plus(BigInteger(number))
        }

        when (sum.signum()) {
            0 -> {
                writer.write("0\n")
            }
            1 -> {
                writer.write("+\n")
            }
            else -> {
                writer.write("-\n")
            }
        }
    }
    writer.flush()
}