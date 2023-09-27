package tags.bfs

/**
 * https://www.acmicpc.net/problem/12851
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val (time, count) = getTimeAndCount(n, k)
    println(time)
    println(count)
}

private fun getTimeAndCount(n: Int, k: Int): Pair<Int, Int> {
    val times = IntArray(100001) { Int.MAX_VALUE }
    val counts = IntArray(100001)
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    queue.add(Pair(n, 0))

    while (queue.isNotEmpty()) {
        val (i, time) = queue.poll()
        if (i !in 0..100000 || times[i] < time) {
            continue
        }

        if (times[i] == time) {
            counts[i]++
        } else {
            times[i] = time
            counts[i] = 1
        }

        queue.add(Pair(i - 1, time + 1))
        queue.add(Pair(i * 2, time + 1))
        queue.add(Pair(i + 1, time + 1))
    }

    return Pair(times[k], counts[k])
}
