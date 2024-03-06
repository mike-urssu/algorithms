package tags.bfs

/**
 * https://www.acmicpc.net/problem/2251
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    println(getVolumes(a, b, c).joinToString(" "))
}

private fun getVolumes(a: Int, b: Int, c: Int): Set<Int> {
    val volumes = sortedSetOf<Int>()
    val set = mutableSetOf<Triple<Int, Int, Int>>().apply { this.add(Triple(0, 0, c)) }
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    queue.add(Triple(0, 0, c))

    while (queue.isNotEmpty()) {
        val (a2, b2, c2) = queue.poll()
        if (a2 == 0) {
            volumes.add(c2)
        }

        if (a2 != 0) {
            if (b != b2) {
                if (a2 >= b - b2) {
                    pushIfAbsent(set, queue, Triple(a2 - (b - b2), b, c2))
                } else {
                    if (a2 + b2 <= 200) {
                        pushIfAbsent(set, queue, Triple(0, a2 + b2, c2))
                    }
                }
            }
            if (c != c2) {
                if (a2 >= c - c2) {
                    pushIfAbsent(set, queue, Triple(a2 - (c - c2), b2, c))
                } else {
                    if (a2 + c2 <= 200) {
                        pushIfAbsent(set, queue, Triple(0, b2, a2 + c2))
                    }
                }
            }
        }

        if (b2 != 0) {
            if (c != c2) {
                if (b2 >= c - c2) {
                    pushIfAbsent(set, queue, Triple(a2, b2 - (c - c2), c))
                } else {
                    if (b2 + c2 <= 200) {
                        pushIfAbsent(set, queue, Triple(a2, 0, b2 + c2))
                    }
                }
            }
            if (a != a2) {
                if (b2 >= a - a2) {
                    pushIfAbsent(set, queue, Triple(a, b2 - (a - a2), c2))
                } else {
                    if (a2 + b2 <= 200) {
                        pushIfAbsent(set, queue, Triple(a2 + b2, 0, c2))
                    }
                }
            }
        }

        if (c2 != 0) {
            if (a != a2) {
                if (c2 >= a - a2) {
                    pushIfAbsent(set, queue, Triple(a, b2, c2 - (a - a2)))
                } else {
                    if (a2 + c2 <= 200) {
                        pushIfAbsent(set, queue, Triple(a2 + c2, b2, 0))
                    }
                }
            }
            if (b != b2) {
                if (c2 >= b - b2) {
                    pushIfAbsent(set, queue, Triple(a2, b, c2 - (b - b2)))
                } else {
                    if (b2 + c2 <= 200) {
                        pushIfAbsent(set, queue, Triple(a2, b2 + c2, 0))
                    }
                }
            }
        }
    }

    return volumes
}

private fun pushIfAbsent(
    set: MutableSet<Triple<Int, Int, Int>>,
    queue: Queue<Triple<Int, Int, Int>>,
    bottles: Triple<Int, Int, Int>
) {
    if (!set.contains(bottles)) {
        set.add(bottles)
        queue.add(bottles)
    }
}
