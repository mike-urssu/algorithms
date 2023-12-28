package tags.math

/**
 * https://www.acmicpc.net/problem/1011
 */
import kotlin.math.sqrt

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        println(getCount(x, y))
    }
}

private fun getCount(x: Int, y: Int): Int {
    val distance = y - x
    val max = sqrt(distance.toDouble()).toInt()

    return if (distance == max * max) {
        max * 2 - 1
    } else if (distance <= max * max + max) {
        max * 2
    } else {
        max * 2 + 1
    }
}
