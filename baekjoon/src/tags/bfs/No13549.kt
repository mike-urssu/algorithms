package tags.bfs

/**
 * https://www.acmicpc.net/problem/13549
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val seconds = IntArray(100001) { -1 }

    val queue: Queue<Int> = LinkedList()
    queue.add(n)
    seconds[n] = 0

    while (queue.isNotEmpty()) {
        if (queue.peek() == k) {
            break
        }

        val p = queue.poll()
        var q = p
        while (q * 2 in 0..100000 && seconds[q * 2] == -1) {
            queue.add(q * 2)
            seconds[q * 2] = seconds[q]
            q = q shl 1
        }
        if (p - 1 >= 0 && seconds[p - 1] == -1) {
            queue.add(p - 1)
            seconds[p - 1] = seconds[p] + 1
        }
        if (p + 1 <= 100000 && seconds[p + 1] == -1) {
            queue.add(p + 1)
            seconds[p + 1] = seconds[p] + 1
        }
    }
    println(seconds[k])
}
