package tags.bfs

/**
 * https://www.acmicpc.net/problem/1525
 */
import java.util.PriorityQueue

fun main() {
    val string = getString()
    println(countMovements(string))
}

private fun getString(): String {
    val string = StringBuilder()
    repeat(3) {
        readln().split(" ").forEach { string.append(it) }
    }
    return string.toString()
}

private const val target = "123456780"
private val d = intArrayOf(-3, -1, 3, 1)

private fun countMovements(string: String): Int {
    val history = mutableSetOf<String>()
    val queue = PriorityQueue<Triple<String, Int, Int>> { it, other -> it.third.compareTo(other.third) }

    val zeroIndex = string.indexOf('0')
    history.add(string)
    queue.add(Triple(string, zeroIndex, 0))

    while (queue.isNotEmpty()) {
        val (str, index, count) = queue.poll()
        if (str == target) {
            return count
        }

        for (i in 0 until 4) {
            if (isInBoundary(index, d[i])) {
                val nextIndex = index + d[i]
                val nextStr = swap(str, index, nextIndex)
                if (!history.contains(nextStr)) {
                    history.add(nextStr)
                    queue.add(Triple(nextStr, nextIndex, count + 1))
                }
            }
        }
    }

    return -1
}

private fun isInBoundary(index: Int, d: Int): Boolean {
    return if (index + d !in 0 until 9) {
        false
    } else if (index % 3 == 0 && d == -1) {
        false
    } else {
        !(index % 3 == 2 && d == 1)
    }
}

private fun swap(string: String, index1: Int, index2: Int): String {
    val newGraph = StringBuilder(string)
    val temp = string[index1]
    newGraph[index1] = newGraph[index2]
    newGraph[index2] = temp
    return newGraph.toString()
}
