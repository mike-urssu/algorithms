package tags.math

/**
 * https://www.acmicpc.net/problem/11320
 */
import kotlin.math.ceil

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (a, b) = readln().split(" ").map { it.toDouble() }
        val v = ceil(a / b).toInt()
        println(v * v)
    }
}
