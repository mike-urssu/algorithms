package tags.dp

/**
 * https://www.acmicpc.net/problem/10826
 */
import java.math.BigInteger

fun main() {
    val n = readln().toInt()
    println(getFibonacci()[n])
}

private fun getFibonacci(): Array<BigInteger> {
    val fibonacci = Array<BigInteger>(10001) { BigInteger.ZERO }
    fibonacci[1] = BigInteger.ONE
    (2..10000).forEach { i -> fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1] }
    return fibonacci
}
