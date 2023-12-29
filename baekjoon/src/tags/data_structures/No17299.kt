package tags.data_structures

/**
 * https://www.acmicpc.net/problem/17299
 */
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    println(ngf(n, numbers).joinToString(" "))
}

private fun ngf(n: Int, numbers: IntArray): IntArray {
    val ngf = IntArray(n)
    val counts = IntArray(1_000_001).apply { numbers.forEach { this[it]++ } }
    val stack = Stack<Int>()

    (n - 1 downTo 0).forEach { i ->
        while (stack.isNotEmpty()) {
            val c1 = counts[numbers[i]]
            val c2 = counts[stack.peek()]
            if (c1 < c2) {
                break
            }
            stack.pop()
        }

        ngf[i] = if (stack.isEmpty()) {
            -1
        } else {
            stack.peek()
        }

        stack.push(numbers[i])
    }

    return ngf
}
