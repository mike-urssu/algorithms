package tags.data_structures

/**
 * https://www.acmicpc.net/problem/12789
 */
import java.util.LinkedList
import java.util.Queue
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }

    val queue = LinkedList<Int>().apply { this.addAll(numbers) } as Queue<Int>
    val stack = Stack<Int>()
    var order = 1

    while (queue.isNotEmpty()) {
        if (stack.isNotEmpty() && stack.peek() == order) {
            stack.pop()
            order++
            continue
        }

        val p = queue.poll()
        if (p == order) {
            order++
        } else {
            stack.add(p)
        }
    }

    while (stack.isNotEmpty() && stack.pop() == order) {
        order++
    }

    if (order == n + 1) {
        println("Nice")
    } else {
        println("Sad")
    }
}
