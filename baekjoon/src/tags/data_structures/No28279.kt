package tags.data_structures

/**
 * https://www.acmicpc.net/problem/28279
 */
import java.util.Deque
import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val deque = LinkedList<Int>() as Deque<Int>
    val result = StringBuilder()

    repeat(n) {
        val command = readln().split(" ").map { it.toInt() }
        when (command[0]) {
            1 -> {
                deque.addFirst(command[1])
            }

            2 -> {
                deque.addLast(command[1])
            }

            3 -> {
                if (deque.isEmpty()) {
                    result.append("-1\n")
                } else {
                    result.append("${deque.pollFirst()}\n")
                }
            }

            4 -> {
                if (deque.isEmpty()) {
                    result.append("-1\n")
                } else {
                    result.append("${deque.pollLast()}\n")
                }
            }

            5 -> {
                result.append("${deque.size}\n")
            }

            6 -> {
                if (deque.isEmpty()) {
                    result.append("1\n")
                } else {
                    result.append("0\n")
                }
            }

            7 -> {
                if (deque.isEmpty()) {
                    result.append("-1\n")
                } else {
                    result.append("${deque.peekFirst()}\n")
                }
            }

            8 -> {
                if (deque.isEmpty()) {
                    result.append("-1\n")
                } else {
                    result.append("${deque.peekLast()}\n")
                }
            }
        }
    }

    println(result)
}
