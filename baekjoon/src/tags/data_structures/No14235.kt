package tags.data_structures

/**
 * https://www.acmicpc.net/problem/14235
 */
import java.util.PriorityQueue
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val priorityQueue = PriorityQueue<Int>(reverseOrder())
    val n = scanner.nextInt()
    repeat(n) {
        val a = scanner.nextInt()
        if (a == 0) {
            val v = if (priorityQueue.isEmpty()) {
                -1
            } else {
                priorityQueue.poll()
            }
            println(v)
        } else {
            repeat(a) {
                priorityQueue.add(scanner.nextInt())
            }
        }
    }
}
