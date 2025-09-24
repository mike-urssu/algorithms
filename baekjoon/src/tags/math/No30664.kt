package tags.math

/**
 * https://www.acmicpc.net/problem/30664
 */
import java.math.BigInteger

fun main() {
    while (true) {
        val n = readln()
        if (n == "0") {
            break
        }
        if (n.toBigInteger().mod(BigInteger.valueOf(42L)) == BigInteger.ZERO) {
            println("PREMIADO")
        } else {
            println("TENTE NOVAMENTE")
        }
    }
}
