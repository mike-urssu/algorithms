package tags.bfs

/**
 * https://www.acmicpc.net/problem/14248
 */
import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

private val scanner = Scanner(System.`in`)

fun main() {
    val n = scanner.nextInt()
    val distances = IntArray(n) { scanner.nextInt() }
    val s = scanner.nextInt()

    val isVisited = BooleanArray(n)
    val queue: Queue<Int> = LinkedList()
    isVisited[s - 1] = true
    queue.add(s - 1)
    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val left = p - distances[p]
        if (0 <= left && !isVisited[left]) {
            isVisited[left] = true
            queue.add(left)
        }
        val right = p + distances[p]
        if (right < n && !isVisited[right]) {
            isVisited[right] = true
            queue.add(right)
        }
    }

    println(isVisited.count { it })
}
