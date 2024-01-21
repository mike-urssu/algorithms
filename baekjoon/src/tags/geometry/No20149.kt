package tags.geometry

/**
 * https://www.acmicpc.net/problem/20149
 */
import kotlin.math.sign

fun main() {
    val (x1, y1, x2, y2) = readln().split(" ").map { it.toLong() }
    val (x3, y3, x4, y4) = readln().split(" ").map { it.toLong() }

    val ccw1 = ccw(x1, y1, x2, y2, x3, y3)
    val ccw2 = ccw(x1, y1, x2, y2, x4, y4)
    val ccw3 = ccw(x3, y3, x4, y4, x1, y1)
    val ccw4 = ccw(x3, y3, x4, y4, x2, y2)

    if (ccw1 * ccw2 == 0 && ccw3 * ccw4 == 0) {
        val a: Pair<Long, Long>
        val b: Pair<Long, Long>
        val c: Pair<Long, Long>
        val d: Pair<Long, Long>

        if (Pair(x1, y1) isGreaterThan Pair(x2, y2)) {
            a = Pair(x2, y2)
            b = Pair(x1, y1)
        } else {
            a = Pair(x1, y1)
            b = Pair(x2, y2)
        }

        if (Pair(x3, y3) isGreaterThan Pair(x4, y4)) {
            c = Pair(x4, y4)
            d = Pair(x3, y3)
        } else {
            c = Pair(x3, y3)
            d = Pair(x4, y4)
        }

        if (d isGreaterThanEqual a && b isGreaterThanEqual c) {
            println(1)
            printCoordinatesIfExists(a.first, a.second, b.first, b.second, c.first, c.second, d.first, d.second)
        } else {
            println(0)
        }
    } else {
        if (ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0) {
            println(1)
            printCoordinatesIfExists(x1, y1, x2, y2, x3, y3, x4, y4)
        } else {
            println(0)
        }
    }
}

private fun ccw(x1: Long, y1: Long, x2: Long, y2: Long, x3: Long, y3: Long) =
    ((x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3)).sign

private fun printCoordinatesIfExists(
    x1: Long, y1: Long, x2: Long, y2: Long,
    x3: Long, y3: Long, x4: Long, y4: Long
) {
    if ((x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1) == 0L) {
        if ((x2 == x3 && y2 == y3) && Pair(x3, y3) isGreaterThanEqual Pair(x1, y1)) {
            println("$x2 $y2")
        } else if ((x1 == x4 && y1 == y4) && Pair(x1, y1) isGreaterThanEqual Pair(x3, y3)) {
            println("$x1 $y1")
        }
    } else {
        val div = ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4)).toDouble()
        val x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / div
        val y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / div
        println("$x $y")
    }
}

private infix fun Pair<Long, Long>.isGreaterThan(other: Pair<Long, Long>): Boolean {
    val xComparison = this.first.compareTo(other.first)
    return if (xComparison != 0) {
        xComparison > 0
    } else {
        this.second > other.second
    }
}

private infix fun Pair<Long, Long>.isGreaterThanEqual(other: Pair<Long, Long>) =
    this.first > other.first || (this.first == other.first && this.second >= other.second)
