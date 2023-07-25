package tags.data_structures

/**
 * https://www.acmicpc.net/problem/17608
 */
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val stack = Stack<Int>().apply {
        repeat(n) {
            val height = readln().toInt()
            this.add(height)
        }
    }

    var count = 1
    var height = stack.pop()
    while (stack.isNotEmpty()) {
        val h = stack.pop()
        if (h > height) {
            height = h
            count++
        }
    }
    println(count)
}
