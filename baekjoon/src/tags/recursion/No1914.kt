package tags.recursion

/**
 * https://www.acmicpc.net/problem/1914
 */
import java.math.BigInteger

fun main() {
    val n = readln().toInt()
    println(BigInteger.valueOf(2).pow(n) - BigInteger.ONE)

    if (n <= 20) {
        move(n, 1, 2, 3)
    }
}

private fun move(n: Int, left: Int, mid: Int, right: Int) {
    if (n == 1) {
        println("$left $right")
        return
    }

    move(n - 1, left, right, mid)
    println("$left $right")
    move(n - 1, mid, left, right)
}
