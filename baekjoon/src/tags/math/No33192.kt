package tags.math

/**
 * https://www.acmicpc.net/problem/33192
 */
import java.text.DecimalFormat

fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (x, k, h) = readln().split(" ").map { it.toInt() }
        val v = (((minOf(k - h, 140) + maxOf(0, k - h - 140) * 1.5) + 2 * h) * x).toInt()
        println(DecimalFormat("#,###").format(v))
    }
}
