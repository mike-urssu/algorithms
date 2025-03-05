package tags.sorting

/**
 * https://www.acmicpc.net/problem/15970
 */
fun main() {
    val n = readln().toInt()
    val points = getPoints(n)
    val sum = points.sumOf {
        it.indices.sumOf { i ->
            when (i) {
                0 -> it[1] - it[i]
                it.lastIndex -> it[i] - it[it.lastIndex - 1]
                else -> minOf(it[i + 1] - it[i], it[i] - it[i - 1])
            }
        }
    }
    println(sum)
}

private fun getPoints(n: Int): Array<MutableList<Int>> {
    val points = Array(n + 1) { mutableListOf<Int>() }
    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        points[y].add(x)
    }
    points.forEach { it.sort() }
    return points
}
