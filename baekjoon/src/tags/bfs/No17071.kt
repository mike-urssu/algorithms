package tags.bfs

/**
 * https://www.acmicpc.net/problem/17071
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    println(getLeastTime(n, k))
}

private fun getLeastTime(n: Int, k: Int): Int {
    val times = getTimes(n)
    return (0..1000).find { i ->
        val nextK = k + i * (i + 1) / 2
        nextK <= 500000 && times[i % 2][nextK] <= i
    } ?: -1
}

private fun getTimes(n: Int): Array<IntArray> {
    val times = Array(2) { IntArray(500001) { Int.MAX_VALUE } }
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    queue.add(Pair(n, 0))

    while (queue.isNotEmpty()) {
        val (i, t) = queue.poll()
        if (i !in 0..500000 || times[t % 2][i] != Int.MAX_VALUE) {
            continue
        }

        times[t % 2][i] = t
        queue.add(Pair(i - 1, t + 1))
        queue.add(Pair(i * 2, t + 1))
        queue.add(Pair(i + 1, t + 1))
    }

    return times
}
