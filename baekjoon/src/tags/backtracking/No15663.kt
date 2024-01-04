package tags.backtracking

/**
 * https://www.acmicpc.net/problem/15663
 */
import java.util.SortedSet

private lateinit var numbers: IntArray
private lateinit var isVisited: BooleanArray
private lateinit var sequences: SortedSet<IntArray>
private lateinit var combination: IntArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    numbers = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    isVisited = BooleanArray(n)

    sequences = sortedSetOf<IntArray>(comparator())
    combination = IntArray(m)
    combination(n, m, 0)

    sequences.forEach { println(it.joinToString(" ")) }
}

private fun comparator() = Comparator<IntArray> { it, other ->
    val index = it.indices.firstOrNull { i -> it[i] != other[i] } ?: it.size
    if (index == it.size) {
        0
    } else {
        it[index].compareTo(other[index])
    }
}

private fun combination(n: Int, m: Int, index: Int) {
    if (m == index) {
        sequences.add(combination.clone())
        return
    }

    for (i in 0 until n) {
        if (!isVisited[i]) {
            isVisited[i] = true
            combination[index] = numbers[i]
            combination(n, m, index + 1)
            isVisited[i] = false
        }
    }
}
