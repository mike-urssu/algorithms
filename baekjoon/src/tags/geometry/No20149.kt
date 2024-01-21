package tags.geometry

/**
 * https://www.acmicpc.net/problem/20149
 */
import java.util.Optional
import kotlin.math.sign

private lateinit var a: Pair<Long, Long>
private lateinit var b: Pair<Long, Long>
private lateinit var c: Pair<Long, Long>
private lateinit var d: Pair<Long, Long>

private var isIntersecting = false
private var coordinates = Optional.empty<Pair<Double, Double>>()

fun main() {
    val (x1, y1, x2, y2) = readln().split(" ").map { it.toLong() }
    val (x3, y3, x4, y4) = readln().split(" ").map { it.toLong() }
    setPoints(Pair(x1, y1), Pair(x2, y2), Pair(x3, y3), Pair(x4, y4))

    val ccw1 = ccw(a, b, c)
    val ccw2 = ccw(a, b, d)
    val ccw3 = ccw(c, d, a)
    val ccw4 = ccw(c, d, b)

    if (formOneLine(ccw1, ccw2, ccw3, ccw4)) {
        if (d isGreaterThanEqual a && b isGreaterThanEqual c) {
            isIntersecting = true
            if (a == d && a isGreaterThan c) {
                coordinates = Optional.of(Pair(a.first.toDouble(), a.second.toDouble()))
            } else if (b == c && c isGreaterThan a) {
                coordinates = Optional.of(Pair(b.first.toDouble(), b.second.toDouble()))
            }
        }
    } else {
        if (meetAtOnePoint(ccw1, ccw2, ccw3, ccw4)) {
            isIntersecting = true
            coordinates = Optional.of(getCoordinates())
        }
    }

    if (isIntersecting) {
        println(1)
        if (coordinates.isPresent) {
            val (x, y) = coordinates.get()
            println("$x $y")
        }
    } else {
        println(0)
    }
}

private fun setPoints(
    p1: Pair<Long, Long>, p2: Pair<Long, Long>,
    p3: Pair<Long, Long>, p4: Pair<Long, Long>
) {
    if (p2 isGreaterThan p1) {
        a = p1
        b = p2
    } else {
        b = p1
        a = p2
    }

    if (p4 isGreaterThan p3) {
        c = p3
        d = p4
    } else {
        d = p3
        c = p4
    }
}

private fun ccw(p1: Pair<Long, Long>, p2: Pair<Long, Long>, p3: Pair<Long, Long>) =
    ((p1.first * p2.second + p2.first * p3.second + p3.first * p1.second) -
            (p2.first * p1.second + p3.first * p2.second + p1.first * p3.second)).sign

private fun formOneLine(
    ccw1: Int, ccw2: Int,
    ccw3: Int, ccw4: Int
) = isParallel() && formOneLineOrMeetAtTheEnd(ccw1, ccw2, ccw3, ccw4)

private fun isParallel() = (b.first - a.first) * (d.second - c.second) == (d.first - c.first) * (b.second - a.second)

private fun formOneLineOrMeetAtTheEnd(
    ccw1: Int, ccw2: Int,
    ccw3: Int, ccw4: Int
) = ccw1 * ccw2 == 0 && ccw3 * ccw4 == 0

private fun meetAtOnePoint(
    ccw1: Int, ccw2: Int,
    ccw3: Int, ccw4: Int
) = ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0

private fun getCoordinates(): Pair<Double, Double> {
    return if (a == c || a == d) {
        Pair(a.first.toDouble(), a.second.toDouble())
    } else if (b == c || b == d) {
        Pair(b.first.toDouble(), b.second.toDouble())
    } else {
        val div = ((a.first - b.first) * (c.second - d.second) - (a.second - b.second) * (c.first - d.first)).toDouble()
        val x = (a.first * b.second - a.second * b.first) * (c.first - d.first) -
                (a.first - b.first) * (c.first * d.second - c.second * d.first)
        val y = (a.first * b.second - a.second * b.first) * (c.second - d.second) -
                (a.second - b.second) * (c.first * d.second - c.second * d.first)
        (x / div to y / div)
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
