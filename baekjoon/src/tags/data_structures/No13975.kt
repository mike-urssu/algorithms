package tags.data_structures

/**
 * https://www.acmicpc.net/problem/13975
 */
import java.util.PriorityQueue

fun main() {
    val t = readln().toInt()
    repeat(t) {
        readln()
        val numbers = readln().split(" ").map { it.toLong() }

        var sum = 0L
        val queue = PriorityQueue(numbers)
        while (queue.size != 1) {
            val a = queue.poll()
            val b = queue.poll()
            sum += a + b
            queue.add(a + b)
        }
        println(sum)
    }
}
