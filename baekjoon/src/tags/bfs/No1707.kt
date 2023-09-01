package tags.bfs

/**
 * https://www.acmicpc.net/problem/1707
 */
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

private val reader = BufferedReader(InputStreamReader(System.`in`))

private lateinit var graph: Array<MutableList<Int>>
private lateinit var type: IntArray
private lateinit var isVisited: BooleanArray

fun main() {
    val k = reader.readLine().toInt()
    repeat(k) {
        val (v, e) = reader.readLine().split(" ").map { it.toInt() }
        graph = Array(v + 1) { mutableListOf() }
        type = IntArray(v + 1)
        isVisited = BooleanArray(v + 1)
        repeat(e) {
            val (a, b) = reader.readLine().split(" ").map { it.toInt() }
            graph[a].add(b)
            graph[b].add(a)
        }

        if (isBipartiteGraph(v)) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

private fun isBipartiteGraph(v: Int): Boolean {
    val queue: Queue<Int> = LinkedList()
    for (i in 1..v) {
        if (!isVisited[i]) {
            type[i] = 1
            isVisited[i] = true
            queue.add(i)

            while (queue.isNotEmpty()) {
                val p = queue.poll()
                for (node in graph[p]) {
                    if (type[p] == type[node]) {
                        return false
                    }

                    if (!isVisited[node]) {
                        type[node] = if (type[p] == 1) {
                            2
                        } else {
                            1
                        }
                        isVisited[node] = true
                        queue.add(node)
                    }
                }
            }
        }
    }
    return true
}
