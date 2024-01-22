package tags.geometry

/**
 * https://www.acmicpc.net/problem/2162
 */
import kotlin.math.sign

private lateinit var parents: IntArray
private lateinit var lines: Array<Array<Pair<Long, Long>>>

fun main() {
    val n = readln().toInt()
    parents = IntArray(n) { it }
    lines = getLines(n)

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (isIntersecting(lines[i], lines[j])) {
                union(i, j)
            }
        }
    }

    val groups = parents.groupBy { find(it) }
    println(groups.size)
    println(groups.values.maxOf { it.size })
}

private fun getLines(n: Int): Array<Array<Pair<Long, Long>>> {
    val lines = Array(n) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toLong() }
        val p1 = Pair(x1, y1)
        val p2 = Pair(x2, y2)
        if (p1 isGreaterThan p2) {
            arrayOf(p2, p1)
        } else {
            arrayOf(p1, p2)
        }
    }
    return lines
}

private fun isIntersecting(line1: Array<Pair<Long, Long>>, line2: Array<Pair<Long, Long>>): Boolean {
    val ccw1 = ccw(line1[0], line1[1], line2[0])
    val ccw2 = ccw(line1[0], line1[1], line2[1])
    val ccw3 = ccw(line2[0], line2[1], line1[0])
    val ccw4 = ccw(line2[0], line2[1], line1[1])

    return if (ccw1 * ccw2 == 0 && ccw3 * ccw4 == 0) {
        line2[1] isGreaterThanEqual line1[0] && line1[1] isGreaterThanEqual line2[0]
    } else {
        ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0
    }
}

private fun ccw(p1: Pair<Long, Long>, p2: Pair<Long, Long>, p3: Pair<Long, Long>) =
    ((p1.first * p2.second + p2.first * p3.second + p3.first * p1.second) -
            (p2.first * p1.second + p3.first * p2.second + p1.first * p3.second)).sign

private fun union(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)
    if (parentA < parentB) {
        parents[parentB] = parentA
    } else {
        parents[parentA] = parentB
    }
}

private fun find(n: Int): Int {
    if (parents[n] != n) {
        parents[n] = find(parents[n])
    }
    return parents[n]
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
    (this.first > other.first) || (this.first == other.first && this.second >= other.second)
