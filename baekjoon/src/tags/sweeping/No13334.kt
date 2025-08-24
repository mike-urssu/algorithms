package tags.sweeping

/**
 * https://www.acmicpc.net/problem/13334
 */
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val pairs = getPairs(n)
    val d = readln().toInt()

    var max = 0
    val queue = PriorityQueue<Int>()
    pairs
        .filter { (src, dst) -> dst - src <= d }
        .forEach { (src, dst) ->
            val limit = dst - d
            while (queue.isNotEmpty() && queue.peek() < limit) {
                queue.poll()
            }
            queue.add(src)
            max = maxOf(max, queue.size)
        }
    println(max)
}

private fun getPairs(n: Int): List<Pair<Int, Int>> {
    return Array(n) {
        val (src, dst) = readln().split(" ").map { it.toInt() }.sorted()
        src to dst
    }
        .sortedWith { it, other ->
            var c = it.second.compareTo(other.second)
            if (c == 0) {
                c = it.first.compareTo(other.first)
            }
            c
        }
}
