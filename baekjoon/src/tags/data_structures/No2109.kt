package tags.data_structures

/**
 * https://www.acmicpc.net/problem/2109
 */
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val courses = Array(n) {
        val (p, d) = readln().split(" ").map { it.toInt() }
        p to d
    }
    val queue = PriorityQueue<Pair<Int, Int>> { it, other -> -it.first.compareTo(other.first) }
    queue.addAll(courses)

    val isVisited = BooleanArray(10001)
    var price = 0
    while (queue.isNotEmpty()) {
        val (p, d) = queue.poll()
        for (i in d downTo 1) {
            if (!isVisited[i]) {
                isVisited[i] = true
                price += p
                break
            }
        }
    }
    println(price)
}
