package tags.geometry

/**
 * https://www.acmicpc.net/problem/17387
 */
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sign

fun main() {
    val (x1, y1, x2, y2) = readln().split(" ").map { it.toLong() }
    val (x3, y3, x4, y4) = readln().split(" ").map { it.toLong() }

    if (isIntersecting(x1, y1, x2, y2, x3, y3, x4, y4)) {
        println(1)
    } else {
        println(0)
    }
}

private fun isIntersecting(x1: Long, y1: Long, x2: Long, y2: Long, x3: Long, y3: Long, x4: Long, y4: Long): Boolean {
    val sign1 = ccwSign(x1, y1, x2, y2, x3, y3)
    val sign2 = ccwSign(x1, y1, x2, y2, x4, y4)
    val sign3 = ccwSign(x3, y3, x4, y4, x1, y1)
    val sign4 = ccwSign(x3, y3, x4, y4, x2, y2)

    return if (sign1 * sign2 <= 0 && sign3 * sign4 <= 0) {
        if (sign1 * sign2 == 0 && sign3 * sign4 == 0) {
            isOnTheLine(x1, y1, x2, y2, x3, y3, x4, y4) && isOnTheLine(x3, y3, x4, y4, x1, y1, x2, y2)
        } else {
            true
        }
    } else {
        false
    }
}

private fun ccwSign(x1: Long, y1: Long, x2: Long, y2: Long, x3: Long, y3: Long) =
    ((x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3)).sign

private fun isOnTheLine(x1: Long, y1: Long, x2: Long, y2: Long, x3: Long, y3: Long, x4: Long, y4: Long) =
    min(x1, x2) <= max(x3, x4) && min(x3, x4) <= max(x1, x2)
            && min(y1, y2) <= max(y3, y4) && min(y3, y4) <= max(y1, y2)
