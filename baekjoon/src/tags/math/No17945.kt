package tags.math

/**
 * https://www.acmicpc.net/problem/17945
 */
import kotlin.math.sqrt

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    if (a * a - b == 0) {
        println(-a)
    } else {
        val x1 = -a - sqrt((a * a - b).toDouble()).toInt()
        val x2 = -a + sqrt((a * a - b).toDouble()).toInt()
        println("$x1 $x2")
    }
}
