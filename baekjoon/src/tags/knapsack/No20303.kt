package tags.knapsack

/**
 * https://www.acmicpc.net/problem/20303
 */
private val reader = System.`in`.bufferedReader()
private lateinit var parents: IntArray

fun main() {
    val (n, m, k) = reader.readLine().split(" ").map { it.toInt() }
    val candies = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    setParents(n, m)

    val group = getGroup(candies)
    val knapsack = Array(group.size + 1) { IntArray(k) }
    for (i in group.indices) {
        val (size, sum) = group[i]
        for (j in 0 until k) {
            knapsack[i + 1][j] = if (j < size) {
                knapsack[i][j]
            } else {
                maxOf(knapsack[i][j], knapsack[i][j - size] + sum)
            }
        }
    }
    println(knapsack.last().last())
}

private fun setParents(n: Int, m: Int): IntArray {
    parents = IntArray(n) { it }
    repeat(m) {
        val (a, b) = reader.readLine().split(" ").map { it.toInt() - 1 }
        union(a, b)
    }
    return parents
}

private fun find(n: Int): Int {
    if (n != parents[n]) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}

private fun union(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)
    if (parentA != parentB) {
        parents[parentB] = parentA
    }
}

private fun getGroup(candies: IntArray): List<Pair<Int, Int>> {
    val groups = mutableMapOf<Int, MutableList<Int>>()
    for (i in candies.indices) {
        val parent = find(i)
        groups.getOrPut(parent) { mutableListOf() }.add(i)
    }
    return groups.values.map { group ->
        val size = group.size
        val sum = group.sumOf { candies[it] }
        size to sum
    }
}
