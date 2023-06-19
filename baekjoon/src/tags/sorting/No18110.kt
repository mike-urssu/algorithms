package tags.sorting

/**
 * https://www.acmicpc.net/problem/18110
 */
import kotlin.math.roundToInt

fun main() {
    val n = readln().toInt()
    if (n == 0) {
        println(0)
    } else {
        val opinions = IntArray(n) { readln().toInt() }

        val drop = (n.toDouble() * 0.15).roundToInt()
        val validOpinions = opinions.sorted().drop(drop).dropLast(drop)
        println(validOpinions.average().roundToInt())
    }
}
