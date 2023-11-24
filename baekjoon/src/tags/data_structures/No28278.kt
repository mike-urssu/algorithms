package tags.data_structures

/**
 * https://www.acmicpc.net/problem/28278
 */
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val stack = Stack<Int>()
    val result = StringBuilder()

    val n = reader.readLine().toInt()
    repeat(n) {
        val command = reader.readLine().split(" ").map { it.toInt() }
        when (command[0]) {
            1 -> {
                stack.push(command[1])
            }

            2 -> {
                if (stack.isEmpty()) {
                    result.append("-1\n")
                } else {
                    result.append("${stack.pop()}\n")
                }
            }

            3 -> {
                result.append("${stack.size}\n")
            }

            4 -> {
                if (stack.isEmpty()) {
                    result.append("1\n")
                } else {
                    result.append("0\n")
                }
            }

            5 -> {
                if (stack.isEmpty()) {
                    result.append("-1\n")
                } else {
                    result.append("${stack.peek()}\n")
                }
            }
        }
    }
    println(result)
}
