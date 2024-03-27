package tags.math

/**
 * https://www.acmicpc.net/problem/10984
 */
import kotlin.math.roundToInt

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        var sum = 0.0
        var gpa = 0.0
        repeat(n) {
            val (c, g) = readln().split(" ").map { it.toDouble() }
            sum += c
            gpa += c * g
        }
        println("${sum.toInt()} ${(gpa / sum * 10).roundToInt() / 10.0}")
    }
}
