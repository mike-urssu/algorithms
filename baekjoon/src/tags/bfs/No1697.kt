package tags.bfs

/**
 * https://www.acmicpc.net/problem/1697
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val seconds = IntArray(100001)

    val queue: Queue<Int> = LinkedList()
    queue.add(n)

    while (queue.isNotEmpty()) {
        val x = queue.poll()
        if (x == k) {
            break
        }
        if (x - 1 >= 0 && seconds[x - 1] == 0) {
            seconds[x - 1] = seconds[x] + 1
            queue.add(x - 1)
        }
        if (x + 1 <= 100000 && seconds[x + 1] == 0) {
            seconds[x + 1] = seconds[x] + 1
            queue.add(x + 1)
        }
        if (x * 2 <= 100000 && seconds[x * 2] == 0) {
            seconds[x * 2] = seconds[x] + 1
            queue.add(x * 2)
        }
    }
    println(seconds[k])
}
