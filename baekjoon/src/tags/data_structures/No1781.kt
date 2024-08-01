package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1781
 */
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val problems = Array(n) {
        val (d, c) = readln().split(" ").map { it.toInt() }
        d to c
    }.sortedWith { it, other ->
        val c1 = it.first.compareTo(other.first)
        if (c1 == 0) {
            -it.second.compareTo(other.second)
        } else {
            c1
        }
    }

    val queue = PriorityQueue<Int>()
    problems.forEach { (d, c) ->
        if (queue.size < d) {
            queue.add(c)
        } else {
            if (queue.peek() < c) {
                queue.poll()
                queue.add(c)
            }
        }
    }

    var sum = 0
    while (queue.isNotEmpty()) {
        sum += queue.poll()
    }
    println(sum)
}
