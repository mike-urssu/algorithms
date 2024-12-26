package tags.math

/**
 * https://www.acmicpc.net/problem/2547
 */
import java.math.BigInteger

fun main() {
    val t = readln().toInt()
    repeat(t) {
        readln()
        val n = readln().toLong()
        val candies = (0 until n).sumOf { readln().toBigInteger() }
        if (candies.mod(BigInteger.valueOf(n)) == BigInteger.ZERO) {
            println("YES")
        } else {
            println("NO")
        }
    }
}
