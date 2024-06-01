package tags.sorting

/**
 * https://www.acmicpc.net/problem/10431
 */
fun main() {
    val p = readln().toInt()
    repeat(p) {
        val line = readln().split(" ").map { it.toInt() }
        val n = line[0]
        val heights = line.takeLast(20).toIntArray()
        println("$n ${count(heights)}")
    }
}

private fun count(heights: IntArray): Int {
    var count = 0
    val sortedHeights = mutableListOf<Int>()
    heights.forEachIndexed { i, h ->
        val index = sortedHeights.indexOfFirst { it > h }
        if (index != -1) {
            count += (i - index)
        }
        sortedHeights.add(h)
        sortedHeights.sort()
    }
    return count
}
