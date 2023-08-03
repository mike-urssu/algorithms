package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1715
 */
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val queue = PriorityQueue<Int>().apply {
        repeat(n) {
            val card = readln().toInt()
            this.add(card)
        }
    }

    var count = 0
    while (queue.size > 1) {
        val sum = queue.poll() + queue.poll()
        queue.add(sum)
        count += sum
    }
    println(count)
}
