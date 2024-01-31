package tags.math

/**
 * https://www.acmicpc.net/problem/2089
 */
import java.util.Stack
import kotlin.math.ceil

fun main() {
    val n = readln().toInt()
    println(decimalToMinusBinary(n))
}

private fun decimalToMinusBinary(n: Int): String {
    if (n == 0) {
        return "0"
    }

    val bits = Stack<Int>()
    var remainder = n
    while (remainder != 0) {
        val share = ceil(remainder / -2.0).toInt()
        val bit = remainder - (-2 * share)
        bits.push(bit)
        remainder = share
    }

    val minusBinary = StringBuilder()
    while (bits.isNotEmpty()) {
        minusBinary.append(bits.pop())
    }
    return minusBinary.toString()
}
