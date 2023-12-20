package tags.geometry

/**
 * https://www.acmicpc.net/problem/17386
 */
fun main() {
    val (x1, y1, x2, y2) = readln().split(" ").map { it.toLong() }
    val (x3, y3, x4, y4) = readln().split(" ").map { it.toLong() }
    if (isIntersect(x1, y1, x2, y2, x3, y3, x4, y4)) {
        println(1)
    } else {
        println(0)
    }
}

private fun isIntersect(x1: Long, y1: Long, x2: Long, y2: Long, x3: Long, y3: Long, x4: Long, y4: Long) =
    isClockWise(x1, y1, x2, y2, x3, y3) xor isClockWise(x1, y1, x2, y2, x4, y4)
            && isClockWise(x3, y3, x4, y4, x1, y1) xor isClockWise(x3, y3, x4, y4, x2, y2)

private fun isClockWise(x1: Long, y1: Long, x2: Long, y2: Long, x3: Long, y3: Long) =
    x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2 < 0
