package tags.data_structures

/**
 * https://www.acmicpc.net/problem/17952
 */
import java.util.Stack

fun main() {
    val n = readln().toInt()
    var score = 0
    val stack = Stack<Pair<Int, Int>>()
    repeat(n) {
        val input = readln().split(" ").map { it.toInt() }
        if (input[0] == 1) {
            val (a, t) = input.drop(1)
            if (t == 1) {
                score += a
            } else {
                stack.push(a to t - 1)
            }
        } else {
            if (stack.isNotEmpty()) {
                val (a, t) = stack.pop()
                if (t == 1) {
                    score += a
                } else {
                    stack.push(a to t - 1)
                }
            }
        }
    }
    println(score)
}
