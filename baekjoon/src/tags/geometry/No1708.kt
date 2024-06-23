package tags.geometry

/**
 * https://www.acmicpc.net/problem/1708
 */
import java.util.Stack
import kotlin.math.sign

fun main() {
    val n = readln().toInt()
    val coordinates = getCoordinates(n)
    println(convexHull(n, coordinates))
}

private fun getCoordinates(n: Int): List<Pair<Long, Long>> {
    val coordinates = Array(n) {
        val (x, y) = readln().split(" ").map { it.toLong() }
        x to y
    }

    val p = coordinates.sortedWith { it, other ->
        val compareY = it.second.compareTo(other.second)
        if (compareY == 0) {
            it.first.compareTo(other.first)
        } else {
            compareY
        }
    }.first()

    return coordinates.sortedWith(comparator(p))
}

private fun comparator(root: Pair<Long, Long>) = Comparator<Pair<Long, Long>> { it, other ->
    val ccw = ccw(root, it, other)
    if (ccw > 0) {
        -1
    } else if (ccw < 0) {
        1
    } else {
        val distance1 = getDistance(root, it)
        val distance2 = getDistance(root, other)
        if (distance1 > distance2) {
            1
        } else {
            -1
        }
    }
}

private fun getDistance(p1: Pair<Long, Long>, p2: Pair<Long, Long>) =
    (p2.first - p1.first) * (p2.first - p1.first) + (p2.second - p1.second) * (p2.second - p1.second)

private fun convexHull(n: Int, coordinates: List<Pair<Long, Long>>): Int {
    val stack = Stack<Int>()
    stack.push(0)
    stack.push(1)

    var i1: Int
    var i2: Int
    var i3 = 2

    while (i3 < n) {
        while (stack.size >= 2) {
            i2 = stack.pop()
            i1 = stack.peek()
            val ccw = ccw(coordinates[i1], coordinates[i2], coordinates[i3])
            if (ccw > 0) {
                stack.push(i2)
                break
            }
        }
        stack.push(i3)
        i3++
    }

    return stack.size
}

private fun ccw(p1: Pair<Long, Long>, p2: Pair<Long, Long>, p3: Pair<Long, Long>) =
    ((p1.first * p2.second + p2.first * p3.second + p3.first * p1.second) -
        (p1.second * p2.first + p2.second * p3.first + p3.second * p1.first)).sign
