package tags.dp

/**
 * https://www.acmicpc.net/problem/12852
 */
private val paths = IntArray(1000001) { Int.MAX_VALUE }
private val counts = IntArray(1000001)

fun main() {
    val n = readln().toInt()

    setPathsAndCounts()

    println(counts[n])
    var index = n
    while (index != 0) {
        print("$index ")
        index = paths[index]
    }
}

private fun setPathsAndCounts() {
    paths[0] = 0
    paths[1] = 0
    for (i in 2..1000000) {
        val a = if (i % 3 == 0) {
            i / 3
        } else {
            Int.MAX_VALUE
        }
        val b = if (i % 2 == 0) {
            i / 2
        } else {
            Int.MAX_VALUE
        }
        val c = i - 1
        val count = listOf(a, b, c).filter { it != Int.MAX_VALUE }.minOf { counts[it] }
        paths[i] = listOf(a, b, c).filter { it != Int.MAX_VALUE }.first { counts[it] == count }
        counts[i] = count + 1
    }
}
