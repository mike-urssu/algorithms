package tags.math

/**
 * https://www.acmicpc.net/problem/10480
 */
import kotlin.math.absoluteValue

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        if (n.absoluteValue % 2 == 0) {
            println("$n is even")
        } else {
            println("$n is odd")
        }
    }
}
