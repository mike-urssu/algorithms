package tags.string

import java.util.Deque
import java.util.LinkedList

/**
 * https://www.acmicpc.net/problem/12904
 */
fun main() {
    val s = readln()
    val t = readln()

    val deque: Deque<Char> = LinkedList()
    t.forEach { deque.add(it) }

    var isInOrder = true
    while (deque.size != s.length) {
        if (isInOrder && deque.last == 'A') {
            deque.pollLast()
        } else if (isInOrder && deque.last == 'B') {
            isInOrder = false
            deque.pollLast()
        } else if (!isInOrder && deque.first == 'A') {
            deque.pollFirst()
        } else if (!isInOrder && deque.first == 'B') {
            isInOrder = true
            deque.pollFirst()
        }
    }

    val str = if (isInOrder) {
        deque.joinToString("")
    } else {
        deque.joinToString("").reversed()
    }

    if (s == str) {
        println(1)
    } else {
        println(0)
    }
}
