package tags.dp

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

/**
 * https://www.acmicpc.net/problem/2407
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val input = reader.readLine().split(' ').map { it.toInt() }
    writer.write(combination(input[0], input[1]).toString())
    writer.flush()
}

private fun combination(n: Int, r: Int): BigInteger {
    var number = BigInteger.ONE
    for (i in 0 until r) {
        number = number.multiply(BigInteger.valueOf((n - i).toLong()))
        number = number.divide(BigInteger.valueOf((i + 1).toLong()))
    }
    return number
}
