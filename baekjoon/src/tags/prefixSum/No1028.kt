package tags.prefixSum

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1028
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (r, c) = reader.readLine().split(" ").map { it.toInt() }
    val graph = Array(r) { reader.readLine().toCharArray().map { it.digitToInt() }.toIntArray() }
    val leftDown = getLeftDown(r, c, graph)
    val leftUp = getLeftUp(r, c, graph)
    val rightDown = getRightDown(r, c, graph)
    val rightUp = getRightUp(r, c, graph)

    var max = 0
    for (i in 0 until r) {
        for (j in 0 until c) {
            val n1 = minOf(leftDown[i][j], leftUp[i][j])
            for (n in n1 downTo max + 1) {
                val j2 = j + (n - 1) * 2
                if (j2 >= c) {
                    continue
                }
                val n2 = minOf(rightDown[i][j2], rightUp[i][j2])
                if (n <= n2) {
                    max = n
                }
            }
        }
    }
    writer.write("$max")
    writer.flush()
}

private fun getLeftDown(r: Int, c: Int, graph: Array<IntArray>): Array<IntArray> {
    val leftDown = Array(r) { IntArray(c) }
    (0 until r).forEach { i ->
        (c - 1 downTo 0).forEach { j ->
            if (graph[i][j] == 1) {
                if (i == 0 || j == c - 1) {
                    leftDown[i][j] = 1
                } else {
                    leftDown[i][j] = leftDown[i - 1][j + 1] + 1
                }
            }
        }
    }
    return leftDown
}

private fun getLeftUp(r: Int, c: Int, graph: Array<IntArray>): Array<IntArray> {
    val rightDown = Array(r) { IntArray(c) }
    (r - 1 downTo 0).forEach { i ->
        (c - 1 downTo 0).forEach { j ->
            if (graph[i][j] == 1) {
                if (i == r - 1 || j == c - 1) {
                    rightDown[i][j] = 1
                } else {
                    rightDown[i][j] = rightDown[i + 1][j + 1] + 1
                }
            }
        }
    }
    return rightDown
}

private fun getRightDown(r: Int, c: Int, graph: Array<IntArray>): Array<IntArray> {
    val rightDown = Array(r) { IntArray(c) }
    (0 until r).forEach { i ->
        (0 until c).forEach { j ->
            if (graph[i][j] == 1) {
                if (i == 0 || j == 0) {
                    rightDown[i][j] = 1
                } else {
                    rightDown[i][j] = rightDown[i - 1][j - 1] + 1
                }
            }
        }
    }
    return rightDown
}

private fun getRightUp(r: Int, c: Int, graph: Array<IntArray>): Array<IntArray> {
    val rightUp = Array(r) { IntArray(c) }
    (r - 1 downTo 0).forEach { i ->
        (0 until c).forEach { j ->
            if (graph[i][j] == 1) {
                if (i == r - 1 || j == 0) {
                    rightUp[i][j] = 1
                } else {
                    rightUp[i][j] = rightUp[i + 1][j - 1] + 1
                }
            }
        }
    }
    return rightUp
}
