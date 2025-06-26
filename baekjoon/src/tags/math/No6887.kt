package tags.math

/**
 * https://www.acmicpc.net/problem/6887
 */
import kotlin.math.sqrt

fun main() {
    val n = readln().toDouble()
    println("The largest square has side length ${sqrt(n).toInt()}.")
}
