package tags.bfs

/**
 * https://www.acmicpc.net/problem/9205
 */
import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val stores = mutableListOf<Pair<Int, Int>>()
        val (x1, y1) = readln().split(" ").map { it.toInt() }
        val src = Pair(x1, y1)
        repeat(n) {
            val (x, y) = readln().split(" ").map { it.toInt() }
            stores.add(Pair(x, y))
        }
        val (x2, y2) = readln().split(" ").map { it.toInt() }
        val dst = Pair(x2, y2)

        if (canGo(n, src, dst, stores)) {
            println("happy")
        } else {
            println("sad")
        }
    }
}

private fun canGo(n: Int, src: Pair<Int, Int>, dst: Pair<Int, Int>, stores: List<Pair<Int, Int>>): Boolean {
    if (getDistance(src.first, src.second, dst.first, dst.second) <= 1000) {
        return true
    }

    val srcToStores = getDistances(src, n, stores)
    val storesToStores = getDistances(n, stores)
    val storesToDst = getDistances(dst, n, stores)
    val isVisited = Array(n) { BooleanArray(n) }
    val queue: Queue<Int> = LinkedList()
    srcToStores.forEachIndexed { i, distance ->
        if (distance <= 1000) {
            queue.add(i)
        }
    }

    while (queue.isNotEmpty()) {
        val i = queue.poll()
        if (storesToDst[i] <= 1000) {
            return true
        }

        for (j in 0 until n) {
            if (!isVisited[i][j] && storesToStores[i][j] <= 1000) {
                isVisited[i][j] = true
                queue.add(j)
            }
        }
    }

    return false
}

private fun getDistances(src: Pair<Int, Int>, n: Int, stores: List<Pair<Int, Int>>): IntArray {
    val distances = IntArray(n)
    (0 until n).forEach { i -> distances[i] = getDistance(src.first, src.second, stores[i].first, stores[i].second) }
    return distances
}

private fun getDistances(n: Int, stores: List<Pair<Int, Int>>): Array<IntArray> {
    val distances = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == j) {
                continue
            }
            distances[i][j] = getDistance(stores[i].first, stores[i].second, stores[j].first, stores[j].second)
        }
    }
    return distances
}

private fun getDistance(x1: Int, y1: Int, x2: Int, y2: Int) =
    abs(x1 - x2) + abs(y1 - y2)
