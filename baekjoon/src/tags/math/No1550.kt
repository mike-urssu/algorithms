package tags.math

/**
 * https://www.acmicpc.net/problem/1550
 */
import kotlin.math.pow

fun main() {
    val s = readln()
    val hexadecimal = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')
    val decimal = (s.lastIndex downTo 0).sumOf { i -> hexadecimal.indexOf(s[i]) * 16.0.pow(s.lastIndex - i) }.toInt()
    println(decimal)
}
