package tags.recursion

/**
 * https://www.acmicpc.net/problem/1074
 */
import kotlin.math.pow

fun main() {
    val (n, r, c) = readln().split(" ").map { it.toInt() }
    val length = getLength(n, r, c)
    println(getNumber(length, r, c))
}

private fun getLength(n: Int, r: Int, c: Int): Int {
    val max = (r * r).coerceAtLeast(c * c)
    var length = 0
    var mul = 2
    for (i in 1..n) {
        if (max < mul * mul) {
            length = i
            break
        }
        mul *= 2
    }
    return length - 1
}

private fun getNumber(n: Int, r: Int, c: Int): Int {
    return if (n == 0) {
        r * 2 + c
    } else {
        val half = pow(2, n)
        (r / half * 2 + c / half) * pow(4, n) +
                getNumber(n - 1, r % half, c % half)
    }
}

private fun pow(n: Int, m: Int) = n.toDouble().pow(m).toInt()
