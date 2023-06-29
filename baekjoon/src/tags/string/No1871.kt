package tags.string

/**
 * https://www.acmicpc.net/problem/1871
 */
import kotlin.math.absoluteValue
import kotlin.math.pow

fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (s1, s2) = readln().split("-")
        if (isNice(s1, s2)) {
            println("nice")
        } else {
            println("not nice")
        }
    }
}

private fun isNice(s1: String, s2: String): Boolean {
    val indices = ('A'..'Z').toList()
    val v1 = s1.indices.sumOf { i -> indices.indexOf(s1[i]) * 26.0.pow(s1.length - i - 1) }
    val v2 = s2.toInt()
    return (v1 - v2).absoluteValue <= 100
}
