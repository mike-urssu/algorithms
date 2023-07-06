package tags.bruteforcing

import java.math.BigInteger

/**
 * https://www.acmicpc.net/problem/2061
 */
fun main() {
    val (p, k) = readln().split(" ").map { it.toBigInteger() }
    for (i in 2 until k.toInt()) {
        if (p.mod(i.toBigInteger()) == BigInteger.ZERO) {
            println("BAD $i")
            return
        }
    }
    println("GOOD")
}
