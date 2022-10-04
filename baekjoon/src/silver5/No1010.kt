package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

/**
 * https://www.acmicpc.net/problem/1010
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val numbers = reader.readLine().split(" ").map { it.toLong() }
        writer.write("${combination(numbers[1], numbers[0].coerceAtMost(numbers[1] - numbers[0]))}\n")
    }
    writer.flush()
}

private fun combination(number1: Long, number2: Long): BigInteger {
    return factorial(BigInteger.valueOf(number1)) /
            (factorial(BigInteger.valueOf(number1 - number2)) * factorial(BigInteger.valueOf(number2)))
}

private fun factorial(number: BigInteger): BigInteger {
    return if (number == BigInteger.ZERO || number == BigInteger.ONE)
        BigInteger.ONE
    else
        number * factorial(number.minus(BigInteger.ONE))
}