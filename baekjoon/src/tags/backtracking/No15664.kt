package tags.backtracking

/**
 * https://www.acmicpc.net/problem/15664
 */
private lateinit var numbers: IntArray
private lateinit var isVisited: BooleanArray
private lateinit var combination: IntArray
private val combinations = sortedSetOf<IntArray>({ it, other ->
    val index = it.indices.firstOrNull { i -> it[i] != other[i] } ?: -1
    if (index == -1) {
        0
    } else {
        it[index].compareTo(other[index])
    }
})

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    numbers = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    isVisited = BooleanArray(n)
    combination = IntArray(m)

    combination(n, m, 0, 0)

    combinations.forEach { println(it.joinToString(" ")) }
}

private fun combination(n: Int, r: Int, cIndex: Int, nIndex: Int) {
    if (cIndex == r) {
        combinations.add(combination.copyOf())
        return
    }

    for (i in nIndex until n) {
        if (!isVisited[i]) {
            combination[cIndex] = numbers[i]
            isVisited[i] = true
            combination(n, r, cIndex + 1, i)
            isVisited[i] = false
        }
    }
}
