package tags.data_structures

/**
 * https://www.acmicpc.net/problem/2304
 */
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val corners = Array(n) {
        val (l, h) = readln().split(" ").map { it.toInt() }
        l to h
    }.sortedBy { it.first }
    println(getArea(n, corners))
}

private fun getArea(n: Int, corners: List<Pair<Int, Int>>): Int {
    var area = 0

    val stack = Stack<Pair<Int, Int>>()
    for (i in 0 until n) {
        if (stack.isEmpty()) {
            stack.push(corners[i])
        } else {
            val (l1, h1) = stack.peek()
            val (l2, h2) = corners[i]

            if (h1 <= h2) {
                area += (l2 - l1) * h1
                stack.pop()
                stack.push(corners[i])
            }
        }
    }
    area += stack.pop().second

    for (i in n - 1 downTo 0) {
        if (stack.isEmpty()) {
            stack.push(corners[i])
        } else {
            val (l1, h1) = stack.peek()
            val (l2, h2) = corners[i]

            if (h2 >= h1) {
                area += (l1 - l2) * h1
                stack.pop()
                stack.push(corners[i])
            }
        }
    }
    area += stack.pop().second


    val maxH = corners.maxOf { it.second }
    val maxCorners = corners.filter { it.second == maxH }
    area -= (maxCorners.last().first - maxCorners.first().first + 1) * maxH
    return area
}
