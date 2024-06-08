package tags.data_structures

/**
 * https://www.acmicpc.net/problem/2014
 */
import java.util.PriorityQueue

fun main() {
    val (k, n) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toLong() }

    val queue = PriorityQueue(numbers)
    repeat(n - 1) {
        val p = queue.poll()
        for (i in 0 until k) {
            queue.add(p * numbers[i])
            if (p % numbers[i] == 0L) {
                break
            }
        }
    }
    println(queue.poll())
}
