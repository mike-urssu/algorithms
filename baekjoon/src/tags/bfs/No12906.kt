package tags.bfs

/**
 * https://www.acmicpc.net/problem/12906
 */
import java.util.PriorityQueue

fun main() {
    val plateA = readln().split(" ")
    val plateB = readln().split(" ")
    val plateC = readln().split(" ")

    val a = if (plateA[0].toInt() != 0) {
        plateA[1]
    } else {
        ""
    }

    val b = if (plateB[0].toInt() != 0) {
        plateB[1]
    } else {
        ""
    }

    val c = if (plateC[0].toInt() != 0) {
        plateC[1]
    } else {
        ""
    }

    hanoi(a, b, c)
}

private val queue = PriorityQueue<Pair<Triple<String, String, String>, Int>> { it, other -> it.second.compareTo(other.second) }
private val isVisited = mutableSetOf<Triple<String, String, String>>()

private fun hanoi(plateA: String, plateB: String, plateC: String) {
    queue.add(Triple(plateA, plateB, plateC) to 0)
    isVisited.add(Triple(plateA, plateB, plateC))

    while (queue.isNotEmpty()) {
        val (hanoi, count) = queue.poll()
        val (a, b, c) = hanoi
        if (isFinished(a, b, c)) {
            println(count)
            return
        }

        if (a.isNotEmpty()) {
            val newA = a.substring(0, a.lastIndex)
            val newB = b + a.last()
            val newC = c + a.last()

            var newHanoi = Triple(newA, newB, c)
            putIfAbsent(newHanoi, count)

            newHanoi = Triple(newA, b, newC)
            putIfAbsent(newHanoi, count)
        }

        if (b.isNotEmpty()) {
            val newA = a + b.last()
            val newB = b.substring(0, b.lastIndex)
            val newC = c + b.last()

            var newHanoi = Triple(newA, newB, c)
            putIfAbsent(newHanoi, count)

            newHanoi = Triple(a, newB, newC)
            putIfAbsent(newHanoi, count)
        }

        if (c.isNotEmpty()) {
            val newA = a + c.last()
            val newB = b + c.last()
            val newC = c.substring(0, c.lastIndex)

            var newHanoi = Triple(newA, b, newC)
            putIfAbsent(newHanoi, count)

            newHanoi = Triple(a, newB, newC)
            putIfAbsent(newHanoi, count)
        }
    }
}

private fun isFinished(a: String, b: String, c: String): Boolean {
    return (a.isEmpty() || a.all { it == 'A' })
        && (b.isEmpty() || b.all { it == 'B' })
        && (c.isEmpty() || c.all { it == 'C' })
}

private fun putIfAbsent(hanoi: Triple<String, String, String>, count: Int) {
    if (!isVisited.contains(hanoi)) {
        queue.add(hanoi to count + 1)
        isVisited.add(hanoi)
    }
}
