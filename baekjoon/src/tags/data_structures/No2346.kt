package tags.data_structures

/**
 * https://www.acmicpc.net/problem/2346
 */
import java.util.ArrayDeque
import java.util.Deque

fun main() {
    readln()
    val balloons = readln().split(" ").map { it.toInt() }
    val deque: Deque<IntArray> = ArrayDeque<IntArray>().apply {
        balloons.forEachIndexed { i, paper -> this.add(intArrayOf(i + 1, paper)) }
    }

    while (true) {
        val balloon = deque.removeFirst()
        print("${balloon[0]} ")

        if (deque.isEmpty()) {
            break
        }

        if (balloon[1] > 0) {
            repeat(balloon[1] - 1) {
                deque.addLast(deque.removeFirst())
            }
        } else {
            repeat(-balloon[1]) {
                deque.addFirst(deque.removeLast())
            }
        }
    }
}
