package tags.string

/**
 * https://www.acmicpc.net/problem/15312
 */
private val counts = intArrayOf(3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1)

fun main() {
    val a = readln()
    val b = readln()

    var l1 = mutableListOf<Int>()
    a.indices.forEach { i ->
        l1.add(counts[a[i] - 'A'])
        l1.add(counts[b[i] - 'A'])
    }

    while (l1.size > 2) {
        val l2 = mutableListOf<Int>()
        (0 until l1.lastIndex).forEach { i ->
            l2.add((l1[i] + l1[i + 1]) % 10)
        }
        l1 = l2
    }

    println("${l1[0]}${l1[1]}")
}
