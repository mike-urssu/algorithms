package tags.data_structures

/**
 * https://www.acmicpc.net/problem/15828
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val limit = readln().toInt()

    val queue: Queue<Int> = LinkedList()
    while (true) {
        val n = readln().toInt()
        if (n == -1) {
            break
        }

        if (n != 0) {
            if (queue.size + 1 <= limit) {
                queue.add(n)
            }
        } else {
            queue.poll()
        }
    }

    if (queue.isEmpty()) {
        println("empty")
    } else {
        println(queue.joinToString(" "))
    }
}
