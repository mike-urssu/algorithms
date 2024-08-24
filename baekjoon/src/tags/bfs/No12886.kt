package tags.bfs

/**
 * https://www.acmicpc.net/problem/12886
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    val isVisited = mutableSetOf<Triple<Int, Int, Int>>()
    var isValid = false

    fun putIfAbsent(array: IntArray) {
        val triple = Triple(array[0], array[1], array[2])
        if (!isVisited.contains(triple)) {
            queue.add(triple)
            isVisited.add(triple)
        }
    }

    var array = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    putIfAbsent(array)

    while (queue.isNotEmpty()) {
        val (a, b, c) = queue.poll()
        if (a == b && b == c) {
            isValid = true
            break
        }

        array = intArrayOf(a + a, b - a, c).sortedArray()
        putIfAbsent(array)
        array = intArrayOf(a + a, b, c - a).sortedArray()
        putIfAbsent(array)
        array = intArrayOf(a, b + b, c - b).sortedArray()
        putIfAbsent(array)
    }

    if (isValid) {
        println(1)
    } else {
        println(0)
    }
}
