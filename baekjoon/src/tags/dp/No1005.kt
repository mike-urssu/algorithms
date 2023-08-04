package tags.dp

/**
 * https://www.acmicpc.net/problem/1005
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, k) = readln().split(" ").map { it.toInt() }
        val seconds = getSeconds(n)
        val directions = getDirections(n, k)
        val incomingNodes = getIncomingNodes(n, directions)
        val w = readln().toInt()
        println(getMinimumDelay(n, w, seconds, directions, incomingNodes))
    }
}

private fun getSeconds(n: Int) =
    IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }

private fun getDirections(n: Int, k: Int): Array<MutableList<Int>> {
    val directions = Array(n + 1) { mutableListOf<Int>() }
    repeat(k) {
        val (src, dst) = readln().split(" ").map { it.toInt() }
        directions[src].add(dst)
    }
    return directions
}

private fun getIncomingNodes(n: Int, directions: Array<MutableList<Int>>): IntArray {
    val incomingNodes = IntArray(n + 1)
    directions.forEach { nodes ->
        nodes.forEach { i -> incomingNodes[i]++ }
    }
    return incomingNodes
}

private fun getMinimumDelay(
    n: Int,
    w: Int,
    seconds: IntArray,
    directions: Array<MutableList<Int>>,
    incomingNodes: IntArray
): Int {
    val prefixSum = IntArray(n + 1) { seconds[it] }
    val queue: Queue<Int> = LinkedList()
    incomingNodes.forEachIndexed { i, node ->
        if (node == 0) {
            queue.add(i)
        }
    }

    while (queue.isNotEmpty()) {
        val i = queue.poll()
        directions[i].forEach { j ->
            prefixSum[j] = prefixSum[j].coerceAtLeast(prefixSum[i] + seconds[j])
            incomingNodes[j]--
            if (incomingNodes[j] == 0) {
                queue.add(j)
            }
        }
    }

    return prefixSum[w]
}
