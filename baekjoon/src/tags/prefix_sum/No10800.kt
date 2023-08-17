package tags.prefix_sum

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10800
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = reader.readLine().toInt()

    val balls = mutableListOf<Ball>()
    repeat(n) { i ->
        val (c, s) = reader.readLine().split(" ").map { it.toInt() }
        balls.add(Ball(i, c, s))
    }
    balls.sortWith(compareBy({ it.size }, { it.color }))

    val sizes = IntArray(n)
    val colors = mutableMapOf<Int, Int>()
    var sum = 0
    var j = 0
    for (i in 0 until n) {
        val ball1 = balls[i]
        while (true) {
            val ball2 = balls[j]
            if (ball1.size <= ball2.size) {
                break
            }
            sum += ball2.size
            colors[ball2.color] = (colors[ball2.color] ?: 0) + ball2.size
            j++
        }
        sizes[ball1.index] = sum - (colors[ball1.color] ?: 0)
    }

    sizes.forEach { writer.write("$it\n") }
    writer.flush()
}

private class Ball(
    val index: Int,
    val color: Int,
    val size: Int
)
