package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1927
 */
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val priorityQueue = PriorityQueue<Int>()
    repeat(n) {
        val x = readln().toInt()
        if (x > 0) {
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
