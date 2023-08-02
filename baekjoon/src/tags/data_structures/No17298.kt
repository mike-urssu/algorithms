package tags.data_structures

/**
 * https://www.acmicpc.net/problem/17298
 */
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    val nges = IntArray(n)
    (n - 1 downTo 0).forEach { i -> nges[i] = nge(numbers[i]) }
    println(nges.joinToString(" "))
}

private val stack = Stack<Int>()
private fun nge(n: Int): Int {
    while (stack.isNotEmpty() && n >= stack.peek()) {
        stack.pop()
    }

    val nge = stack.lastOrNull() ?: -1
    stack.push(n)
    return nge
}
