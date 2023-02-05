package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

/**
 * https://www.acmicpc.net/problem/2057
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var number = reader.readLine().toBigInteger()

    if (number == BigInteger.ZERO) {
        writer.write("NO")
    } else {
        var currentFactorial = BigInteger.ONE
        var currentNumber = BigInteger.ZERO

        while (number >= currentFactorial.multiply(currentNumber.plus(BigInteger.ONE))) {
            currentNumber = currentNumber.plus(BigInteger.ONE)
            currentFactorial = currentFactorial.multiply(currentNumber)
        }

        while (currentNumber > BigInteger.ZERO) {
            number = number.minus(currentFactorial)
            currentFactorial = currentFactorial.divide(currentNumber)
            currentNumber = currentNumber.minus(BigInteger.ONE)
        }

        if (number > BigInteger.ONE) {
            writer.write("NO")
        } else {
            writer.write("YES")
        }
    }
    writer.flush()
}