package tags.math

/**
 * https://www.acmicpc.net/problem/21612
 */
import kotlin.math.sign

fun main() {
    val b = readln().toInt()
    val p = 5 * b - 400
    println(p)
    println((100 - p).sign)
}
