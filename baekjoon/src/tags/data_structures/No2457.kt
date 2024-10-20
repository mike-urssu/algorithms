package tags.data_structures

/**
 * https://www.acmicpc.net/problem/2457
 */
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val flowers = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
        .sortedWith { it, other ->
            val c0 = it[0].compareTo(other[0])
            if (c0 == 0) {
                val c1 = it[1].compareTo(other[1])
                if (c1 == 0) {
                    val c2 = -it[2].compareTo(other[2])
                    if (c2 == 0) {
                        -it[3].compareTo(other[3])
                    } else {
                        c2
                    }
                } else {
                    c1
                }
            } else {
                c0
            }
        }

    val queue = PriorityQueue<IntArray> { it, other ->
        val c2 = -it[2].compareTo(other[2])
        if (c2 == 0) {
            val c3 = -it[3].compareTo(other[3])
            if (c3 == 0) {
                val c0 = it[0].compareTo(other[0])
                if (c0 == 0) {
                    it[1].compareTo(other[1])
                } else {
                    c0
                }
            } else {
                c3
            }
        } else {
            c2
        }
    }
    for (i in 0 until n) {
        val (m1, d1, m2, d2) = flowers[i]
        if (queue.isEmpty() && isBetween(3, 1, m1, d1, m2, d2 - 1)) {
            queue.add(flowers[i])
        } else if (queue.isNotEmpty()) {
            val (m3, d3, m4, d4) = queue.peek()
            if (isBefore(m1, d1, 3, 1) && isAfter(m2, d2, m4, d4)) {
                queue.poll()
                queue.add(flowers[i])
            } else if (isBetween(m1, d1, m3, d3, m4, d4) && isBetween(m2, d2, m3, d3, m4, d4)) {
                continue
            } else if (isBetween(m4, d4, m1, d1, m2, d2)) {
                queue.add(flowers[i])
            }

            if (isAfter(m2, d2 - 1, 11, 30)) {
                break
            }
        }
    }

    val selected = mutableListOf<IntArray>()
    while (queue.isNotEmpty()) {
        selected.add(queue.poll())
    }
    println(countMin(selected.reversed()))
}

private fun countMin(flowers: List<IntArray>): Int {
    if (flowers.isEmpty()) {
        return 0
    }

    if (!isBefore(flowers[0][0], flowers[0][1], 3, 1) || !isAfter(flowers.last()[2], flowers.last()[3] - 1, 11, 30)) {
        return 0
    }

    if (flowers.any { (m1, d1, m2, d2) -> isBefore(m1, d1, 3, 1) && isAfter(m2, d2 - 1, 11, 30) }) {
        return 1
    }

    var (_, _, m, d) = flowers.first()
    var count = 1
    var index = 1
    while (index < flowers.size) {
        val idx = (1 until flowers.size).findLast { i ->
            val (m1, m2, _, _) = flowers[i]
            isBefore(m1, m2, m, d)
        } ?: -1
        if (idx == -1) {
            break
        }

        val flower = flowers[idx]
        m = flower[2]
        d = flower[3]
        index = idx + 1
        count++
    }
    return count
}

private fun isBetween(m: Int, d: Int, m1: Int, d1: Int, m2: Int, d2: Int) =
    isBefore(m1, d1, m, d) && isAfter(m2, d2, m, d)

private fun isBefore(m1: Int, d1: Int, m2: Int, d2: Int): Boolean {
    return if (m1 > m2) {
        false
    } else if (m1 == m2) {
        d1 <= d2
    } else {
        true
    }
}

private fun isAfter(m1: Int, d1: Int, m2: Int, d2: Int): Boolean {
    return if (m1 < m2) {
        false
    } else if (m1 == m2) {
        d1 >= d2
    } else {
        true
    }
}
