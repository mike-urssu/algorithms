package tags.string

import java.util.Deque
import java.util.LinkedList
import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/5430
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val p = readln()
        readln()
        val s = readln()

        val deque = getDeque(s)
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

        println(getAnswer(deque, isError, isInOrder))
    }
}

private fun getDeque(s: String): Deque<Int> {
    val deque: Deque<Int> = LinkedList()
    val numbers = StringTokenizer(s, "[],")
    while (numbers.hasMoreTokens()) {
        deque.add(numbers.nextToken().toInt())
    }
    return deque
}

private fun getAnswer(deque: Deque<Int>, isError: Boolean, isInOrder: Boolean): String {
    return if (isError) {
        "error"
    } else {
        val answer = StringBuilder()
        if (deque.isNotEmpty()) {
            if (isInOrder) {
                answer.append(deque.pollFirst())
                while (deque.isNotEmpty()) {
                    answer.append(",")
                    answer.append(deque.pollFirst())
                }
            } else {
                answer.append(deque.pollLast())
                while (deque.isNotEmpty()) {
                    answer.append(",")
                    answer.append(deque.pollLast())
                }
            }
        }
        "[$answer]"
    }
}
