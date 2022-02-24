package dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

/**
 * https://www.acmicpc.net/problem/1010
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val numberOfInput = readLine().toInt()
    repeat(numberOfInput) {
        val numbers = readLine().split(' ').map { it.toInt() }

        var combination = BigInteger.valueOf(1)
        for (i in 1..numbers[1])
            combination = combination.multiply(BigInteger.valueOf(i.toLong()))
        for (i in 1..numbers[0])
            combination = combination.divide(BigInteger.valueOf(i.toLong()))
        for (i in 1..numbers[1] - numbers[0])
            combination = combination.divide(BigInteger.valueOf(i.toLong()))

        with(BufferedWriter(OutputStreamWriter(System.out))) {
            write("$combination")
            newLine()
            flush()
        }
    }
}