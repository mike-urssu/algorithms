package tags.implementation

/**
 * https://www.acmicpc.net/problem/20436
 */
import kotlin.math.abs

private val keyboard = mapOf(
    'q' to (0 to 0), 'w' to (0 to 1), 'e' to (0 to 2), 'r' to (0 to 3), 't' to (0 to 4), 'y' to (0 to 5), 'u' to (0 to 6), 'i' to (0 to 7), 'o' to (0 to 8), 'p' to (0 to 9),
    'a' to (1 to 0), 's' to (1 to 1), 'd' to (1 to 2), 'f' to (1 to 3), 'g' to (1 to 4), 'h' to (1 to 5), 'j' to (1 to 6), 'k' to (1 to 7), 'l' to (1 to 8),
    'z' to (2 to 0), 'x' to (2 to 1), 'c' to (2 to 2), 'v' to (2 to 3), 'b' to (2 to 4), 'n' to (2 to 5), 'm' to (2 to 6)
)
private val consonants = setOf('q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v')

fun main() {
    var (l, r) = readln().split(" ").map { it[0] }
    val s = readln().toCharArray()

    var sec = 0
    s.forEach { c ->
        if (c in consonants) {
            sec += calculate(keyboard[l]!!, keyboard[c]!!) + 1
            l = c
        } else {
            sec += calculate(keyboard[r]!!, keyboard[c]!!) + 1
            r = c
        }
    }
    println(sec)
}

private fun calculate(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Int {
    return abs(p1.first - p2.first) + abs(p1.second - p2.second)
}
