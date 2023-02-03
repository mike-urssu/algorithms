package bronze3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

/**
 * https://www.acmicpc.net/problem/2061
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (p, k) = reader.readLine().split(" ").map { it.toBigInteger() }

    var isGoodPassword = true
    for (i in 2 until k.toInt()) {
        if (p.mod(BigInteger.valueOf(i.toLong())) == BigInteger.ZERO) {
            isGoodPassword = false
            writer.write("BAD $i")
            break
        }
    }

    if (isGoodPassword) {
        writer.write("GOOD")
    }
    writer.flush()
}
