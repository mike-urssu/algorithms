package tags.bfs

/**
 * https://www.acmicpc.net/problem/2606
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var computers: Array<MutableList<Int>>
private lateinit var isVisited: BooleanArray

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    computers = getComputers(n, m)
    isVisited = BooleanArray(n + 1)

    bfs()

    println(isVisited.count { it } - 1)
}

private fun getComputers(n: Int, m: Int): Array<MutableList<Int>> {
    val computers = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        computers[x].add(y)
        computers[y].add(x)
    }
    return computers
}

private fun bfs() {
    val queue: Queue<Int> = LinkedList()
    queue.add(1)
    isVisited[1] = true

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        for (c in computers[p]) {
            if (!isVisited[c]) {
                isVisited[c] = true
                queue.add(c)
            }
        }
    }
}
