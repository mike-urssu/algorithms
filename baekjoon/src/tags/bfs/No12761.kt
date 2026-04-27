package tags.bfs

/**
 * https://www.acmicpc.net/problem/12761
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val (a, b, n, m) = readln().split(" ").map { it.toInt() }
    val dist = intArrayOf(1, -1, a, -a, b, -b)
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val isVisited = BooleanArray(100_001)
    queue.add(Pair(n, 0))
    isVisited[n] = true

    while (queue.isNotEmpty()) {
        val (p, c) = queue.poll()
        if (p == m) {
            println(c)
            break
        }

        dist.forEach { d ->
            val nextP = p + d
            if (nextP in 0..100_000 && !isVisited[nextP]) {
                isVisited[nextP] = true
                queue.add(Pair(nextP, c + 1))
            }
        }
        intArrayOf(p * a, p * b).forEach { d ->
            val nextP = d
            if (nextP in 0..100_000 && !isVisited[nextP]) {
                isVisited[nextP] = true
                queue.add(Pair(nextP, c + 1))
            }
        }
    }
}
