package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1735
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val fraction1 = reader.readLine().split(" ").map { it.toLong() }
    val fraction2 = reader.readLine().split(" ").map { it.toLong() }

    val sumOfFraction = sumTwoFractions(fraction1, fraction2)
    val reducedFraction = getReducedFraction(sumOfFraction)

    writer.write("${reducedFraction[0]} ${reducedFraction[1]}")
    writer.flush()
}

private fun sumTwoFractions(fraction1: List<Long>, fraction2: List<Long>): List<Long> {
    val gcd = getGCD(fraction1[1], fraction2[1])
    val lcm = fraction1[1] / gcd * fraction2[1]

    val newFraction = mutableListOf<Long>()
    newFraction.add(fraction1[0] * (lcm / fraction1[1]) + fraction2[0] * (lcm / fraction2[1]))
    newFraction.add(lcm)

    return newFraction
}

private fun getReducedFraction(fraction: List<Long>): LongArray {
    val gcd = getGCD(fraction[0], fraction[1])
    return longArrayOf(fraction[0] / gcd, fraction[1] / gcd)
}

private fun getGCD(number1: Long, number2: Long): Long {
    return if (number2 == 0L)
        number1
    else
        getGCD(number2, number1 % number2)
}