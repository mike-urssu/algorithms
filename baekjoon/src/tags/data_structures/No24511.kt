package tags.data_structures

/**
 * https://www.acmicpc.net/problem/24511
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.toIntArray()
    val b = readln().split(" ").map { it.toInt() }.toIntArray()
    val m = readln().toInt()
    val c = readln().split(" ").map { it.toInt() }.toIntArray()

    val result = StringBuilder()
    val queueStack = getQueueStack(n, a, b, m, c)
    repeat(m) {
        result.append("${queueStack.poll()} ")
    }
    println(result)
}

private fun getQueueStack(n: Int, a: IntArray, b: IntArray, m: Int, c: IntArray): Queue<Int> {
    val queueStack = LinkedList<Int>() as Queue<Int>
    (n - 1 downTo 0).forEach { i ->
        if (a[i] == 0) {
            queueStack.add(b[i])
        }
    }
    (0 until m).forEach { i -> queueStack.add(c[i]) }
    return queueStack
}
