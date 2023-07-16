package tags.data_structures

/**
 * https://www.acmicpc.net/problem/11286
 */
import java.util.PriorityQueue
import kotlin.math.absoluteValue

fun main() {
    val priorityQueue = PriorityQueue<Int> { it, other ->
        if (it.absoluteValue == other.absoluteValue) {
            it.compareTo(other)
        } else {
            it.absoluteValue.compareTo(other.absoluteValue)
        }
    }
    val n = readln().toInt()
    repeat(n) {
        val x = readln().toInt()
        if (x != 0) {
            priorityQueue.add(x)
        } else {
            if (priorityQueue.isEmpty()) {
                println(0)
            } else {
                println(priorityQueue.poll())
            }
        }
    }
}
