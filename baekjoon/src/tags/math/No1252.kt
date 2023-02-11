package tags.math

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

/**
 * https://www.acmicpc.net/problem/1252
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val decimal = reader.readLine().split(" ")
        .map { binaryToDecimal(it) }
        .sumOf { it }
    writer.write(toBinaryString(decimal))
    writer.flush()
}

private fun binaryToDecimal(binary: String): BigInteger {
    var sum = BigInteger.ZERO
    binary.reversed().forEachIndexed { index, bit ->
        if (bit.digitToInt() == 1) {
            sum = sum.plus(BigInteger.valueOf(2).pow(index))
        }
    }
    return sum
}

private fun toBinaryString(decimal: BigInteger): String {
    val binary = StringBuilder()
    var currentValue = decimal
    val two = BigInteger.valueOf(2)

    while (currentValue.divide(two) != BigInteger.ZERO) {
        binary.append(currentValue.mod(two))
        currentValue = currentValue.divide(two)
    }
    binary.append(currentValue)
    return binary.reverse().toString()
}
