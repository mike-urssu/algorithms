package tags.data_structures

/**
 * https://www.acmicpc.net/problem/2493
 */
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val heights = readln().split(" ").map { it.toInt() }
    println(getReceivers(n, heights).joinToString(" "))
}

private fun getReceivers(n: Int, heights: List<Int>): IntArray {
    val receivers = IntArray(n)
    val stack = Stack<Pair<Int, Int>>()
    for (i in 0 until n) {
        while (stack.isNotEmpty() && stack.peek().first < heights[i]) {
            stack.pop()
        }
        if (stack.isEmpty()) {
            receivers[i] = 0
        } else {
            receivers[i] = stack.peek().second
        }
        stack.push(Pair(heights[i], i + 1))
    }
    return receivers
}
