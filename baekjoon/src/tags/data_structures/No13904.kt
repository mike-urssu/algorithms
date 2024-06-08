package tags.data_structures

/**
 * https://www.acmicpc.net/problem/13904
 */
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val queue = PriorityQueue<Pair<Int, Int>> { it, other -> -it.second.compareTo(other.second) }
    repeat(n) {
        val (d, w) = readln().split(" ").map { it.toInt() }
        queue.add(d to w)
    }
    val isVisited = BooleanArray(1001)
    var score = 0
    while (queue.isNotEmpty()) {
        val (d, w) = queue.poll()
        for (i in d downTo 1) {
            if (!isVisited[i]) {
                score += w
                isVisited[i] = true
                break
            }
        }
    }
    println(score)
}
