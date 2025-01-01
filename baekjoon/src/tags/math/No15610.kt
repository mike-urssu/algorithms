package tags.math

/**
 * https://www.acmicpc.net/problem/15610
 */
import kotlin.math.sqrt

fun main() {
    val a = readln().toDouble()
    val l = sqrt(a)
    println(String.format("%.7f", l * 4))
}
