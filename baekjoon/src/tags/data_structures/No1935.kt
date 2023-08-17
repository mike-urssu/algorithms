package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1935
 */
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val s = readln()
    val values = getValues(n)

    val stack = Stack<Double>()
    for (i in s.indices) {
        if (s[i] in 'A'..'Z') {
            stack.push(values[s[i] - 'A'])
        } else {
            val b = stack.pop()
            val a = stack.pop()
            when (s[i]) {
                '+' -> stack.push(a + b)
                '-' -> stack.push(a - b)
                '*' -> stack.push(a * b)
                '/' -> stack.push(a / b)
            }
        }
    }

    println(String.format("%.02f", stack.peek()))
}

private fun getValues(n: Int): DoubleArray {
    val values = DoubleArray(26)
    (0 until n).forEach { i -> values[i] = readln().toDouble() }
    return values
}
