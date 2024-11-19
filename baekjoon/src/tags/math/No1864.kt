package tags.math

/**
 * https://www.acmicpc.net/problem/1864
 */
import java.util.Stack

private val values = mapOf(
    '-' to 0,
    '\\' to 1,
    '(' to 2,
    '@' to 3,
    '?' to 4,
    '>' to 5,
    '&' to 6,
    '%' to 7,
    '/' to -1
)

fun main() {
    while (true) {
        val letters = readln().toCharArray()
        if (letters[0] == '#') {
            break
        }
        println(calculate(letters))
    }
}

private fun calculate(letters: CharArray): Long {
    val stack = Stack<Int>()
    letters.forEach { stack.add(values[it]) }

    var sum = 0L
    var mul = 1
    while (stack.isNotEmpty()) {
        sum += stack.pop() * mul
        mul = mul shl 3
    }
    return sum
}
