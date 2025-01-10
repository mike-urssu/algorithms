package tags.math

/**
 * https://www.acmicpc.net/problem/1484
 */
import kotlin.math.sqrt

fun main() {
    val g = readln().toInt()
    val factors = factors(g)
    val weights = factors.flatMap { f ->
        (((f + 1) shr 1)..f).filter { w ->
            val r = f - w
            r != 0 && (w + r) * (w - r) == g
        }
    }

    if (weights.isEmpty()) {
        println(-1)
    } else {
        weights.forEach { println(it) }
    }
}

private fun factors(g: Int): List<Int> {
    return (1..sqrt(g.toDouble()).toInt())
        .filter { i -> g % i == 0 }
        .map { i -> g / i }
        .reversed()
}
