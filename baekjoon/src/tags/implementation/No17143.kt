package tags.implementation

/**
 * https://www.acmicpc.net/problem/17143
 */
import java.util.SortedSet

private var r = 0
private var c = 0
private var m = 0
private lateinit var sharks: SortedSet<Pair<Pair<Int, Int>, Triple<Int, Int, Int>>>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    r = input[0]
    c = input[1]
    m = input[2]

    sharks = getSharks()

    var size = 0
    (1..c).forEach { j ->
        size += catchShark(j)
        sharks = moveSharks()
    }

    println(size)
}

private fun getSharks(): SortedSet<Pair<Pair<Int, Int>, Triple<Int, Int, Int>>> {
    val sharks = sortedSetOf(comparator())
    repeat(m) {
        val (r, c, s, d, z) = readln().split(" ").map { it.toInt() }
        val coordinates = Pair(r, c)
        val info = Triple(s, d, z)
        sharks.add(Pair(coordinates, info))
    }
    return sharks
}

private fun catchShark(col: Int): Int {
    for (shark in sharks) {
        val (_, y) = shark.first
        val (_, _, z) = shark.second

        if (y == col) {
            sharks.remove(shark)
            return z
        }
    }
    return 0
}

private fun moveSharks(): SortedSet<Pair<Pair<Int, Int>, Triple<Int, Int, Int>>> {
    val nextSharks = sharks.map { getNextShark(it) }
    return distinct(nextSharks)
}

private fun getNextShark(shark: Pair<Pair<Int, Int>, Triple<Int, Int, Int>>): Pair<Pair<Int, Int>, Triple<Int, Int, Int>> {
    val (x, y) = shark.first
    val (s, d, z) = shark.second
    return if (d == 1 || d == 2) {
        val (nextX, nextD) = getMovement(x, s, d, false)
        Pair(Pair(nextX, y), Triple(s, nextD, z))
    } else {
        val (nextY, nextD) = getMovement(y, s, d, true)
        Pair(Pair(x, nextY), Triple(s, nextD, z))
    }
}

private fun getMovement(v: Int, s: Int, d: Int, isParallel: Boolean): Pair<Int, Int> {
    var currentV = v
    var currentD = d

    if (isParallel) {
        repeat(s) {
            if (currentD == 3) {
                if (currentV == c) {
                    currentV = c - 1
                    currentD = 4
                } else {
                    currentV++
                }
            } else {
                if (currentV == 1) {
                    currentV = 2
                    currentD = 3
                } else {
                    currentV--
                }
            }
        }
    } else {
        repeat(s) {
            if (currentD == 1) {
                if (currentV == 1) {
                    currentV = 2
                    currentD = 2
                } else {
                    currentV--
                }
            } else {
                if (currentV == r) {
                    currentV = r - 1
                    currentD = 1
                } else {
                    currentV++
                }
            }
        }
    }

    return Pair(currentV, currentD)
}

private fun distinct(sharks: List<Pair<Pair<Int, Int>, Triple<Int, Int, Int>>>): SortedSet<Pair<Pair<Int, Int>, Triple<Int, Int, Int>>> {
    val distinctSharks = sortedSetOf(comparator())
    sharks.groupBy { it.first }
        .forEach { (c, s) -> distinctSharks.add(Pair(c, getMaxShark(s))) }
    return distinctSharks
}

private fun getMaxShark(sharks: List<Pair<Pair<Int, Int>, Triple<Int, Int, Int>>>): Triple<Int, Int, Int> {
    val maxSpeed = sharks.maxOf { it.second.third }
    return sharks.first { (_, info) -> info.third == maxSpeed }.second
}

private fun comparator() = run {
    Comparator<Pair<Pair<Int, Int>, Triple<Int, Int, Int>>> { it, other ->
        val (r1, c1) = it.first
        val (r2, c2) = other.first
        if (c1 == c2) {
            r1.compareTo(r2)
        } else {
            c1.compareTo(c2)
        }
    }
}
