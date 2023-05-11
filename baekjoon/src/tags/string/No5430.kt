package tags.string

import java.util.Deque
import java.util.LinkedList

/**
 * https://www.acmicpc.net/problem/5430
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val p = readln()
        readln()
        val numbers = readln().drop(1).dropLast(1).split(",")
            .filter { it.isNotEmpty() }
            .map { it.toInt() }

        val deque: Deque<Int> = LinkedList(numbers)
        var isInOrder = true
        var isError = false

        for (c in p) {
            if (c == 'R') {
                isInOrder = !isInOrder
            } else {
                if (deque.isEmpty()) {
                    isError = true
                    break
                }

                if (isInOrder) {
                    deque.pollFirst()
                } else {
                    deque.pollLast()
                }
            }
        }

        if (isError) {
            println("error")
        } else {
            val answer = StringBuilder()
            if (isInOrder) {
                while (deque.isNotEmpty()) {
                    answer.append(deque.pollFirst())
                    answer.append(",")
                }
            } else {
                while (deque.isNotEmpty()) {
                    answer.append(deque.pollLast())
                    answer.append(",")
                }
            }
            println("[${answer.removeSuffix(",")}]")
        }
    }
}
