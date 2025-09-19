package tags.math

/**
 * https://www.acmicpc.net/problem/20352
 */
import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    val a = readln().toDouble()
    val r = sqrt(a / PI)
    println(2 * PI * r)
}
