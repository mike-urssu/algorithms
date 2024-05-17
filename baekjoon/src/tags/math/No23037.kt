package tags.math

/**
 * https://www.acmicpc.net/problem/23037
 */
import kotlin.math.pow

fun main() {
    val n = readln()
    val sum = n.sumOf { it.digitToInt().toDouble().pow(5).toInt() }
    println(sum)
}
