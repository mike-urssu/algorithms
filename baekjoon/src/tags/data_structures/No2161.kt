package tags.data_structures

/**
 * https://www.acmicpc.net/problem/2161
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().toInt()
    val queue: Queue<Int> = LinkedList<Int>().apply {
        (1..n).forEach { this.add(it) }
    }
    while (queue.size > 1) {
        print("${queue.poll()} ")
        queue.add(queue.poll())
    }
    print(queue.poll())
}
