package tags.data_structures

/**
 * https://www.acmicpc.net/problem/15961
 */
import java.util.LinkedList
import java.util.Queue

private val reader = System.`in`.bufferedReader()

fun main() {
    val queue1: Queue<Int> = LinkedList()
    val queue2: Queue<Int> = LinkedList()
    val counts = mutableMapOf<Int, Int>()
    var max = 0

    val (n, _, k, c) = reader.readLine().split(" ").map { it.toInt() }

    repeat(k) {
        val food = reader.readLine().toInt()
        queue2.add(food)
        counts[food] = (counts[food] ?: 0) + 1
        max = max.coerceAtLeast(counts.size)
    }

    repeat(n - k) {
        val food = reader.readLine().toInt()
        queue1.add(food)
    }

    repeat(n) {
        val p2 = queue2.poll()
        counts[p2] = counts[p2]!! - 1
        if (counts[p2] == 0) {
            counts.remove(p2)
        }
        queue1.add(p2)

        val p1 = queue1.poll()
        queue2.add(p1)
        counts[p1] = (counts[p1] ?: 0) + 1

        val distinctCount = if (counts.containsKey(c)) {
            counts.size
        } else {
            counts.size + 1
        }
        max = max.coerceAtLeast(distinctCount)
    }

    println(max)
}
