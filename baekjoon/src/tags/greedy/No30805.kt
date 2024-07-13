package tags.greedy

/**
 * https://www.acmicpc.net/problem/30805
 */
import java.util.Stack

private var n = 0
private lateinit var arrayA: IntArray
private var m = 0
private lateinit var arrayB: IntArray
private lateinit var isVisited: BooleanArray

fun main() {
    n = readln().toInt()
    arrayA = readln().split(" ").map { it.toInt() }.toIntArray()
    m = readln().toInt()
    arrayB = readln().split(" ").map { it.toInt() }.toIntArray()
    isVisited = BooleanArray(n)
    val sequence = getSequence()
    if (sequence.isEmpty()) {
        println(0)
    } else {
        println(sequence.size)
        println(sequence.joinToString(" "))
    }
}

private fun getSequence(): List<Int> {
    val stack = Stack<Int>()
    arrayB.forEachIndexed { i, v ->
        val index = indexOf(v)
        if (index != -1) {
            if (stack.isEmpty()) {
                stack.push(index)
                isVisited[index] = true
            } else {
                while (stack.isNotEmpty() && arrayA[stack.peek()] < v) {
                    val idx = stack.pop()
                    isVisited[idx] = false
                }
                if (stack.isEmpty() || stack.peek() < index) {
                    stack.push(index)
                    isVisited[index] = true
                }
            }
        }
    }
    return stack.map { arrayA[it] }
}

private fun indexOf(v: Int): Int {
    var startIndex = -1
    for (i in 0 until n) {
        if (isVisited[i] && arrayA[i] >= v) {
            startIndex = i
        }
    }

    for (i in startIndex + 1 until n) {
        if (!isVisited[i] && arrayA[i] == v) {
            return i
        }
    }
    return -1
}
