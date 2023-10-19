package tags.dp

/**
 * https://www.acmicpc.net/problem/12852
 */
private val paths = IntArray(1000001) { Int.MAX_VALUE }
private val counts = IntArray(1000001) { Int.MAX_VALUE }

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
    counts[0] = 0
    counts[1] = 0
    for (i in 2..1000000) {
        if (i % 3 == 0) {
            if (counts[i] > counts[i / 3]) {
                paths[i] = i / 3
                counts[i] = counts[i / 3]
            }
        }

        if (i % 2 == 0) {
            if (counts[i] > counts[i / 2]) {
                paths[i] = i / 2
                counts[i] = counts[i / 2]
            }
        }

        if (counts[i] > counts[i - 1]) {
            paths[i] = i - 1
            counts[i] = counts[i - 1]
        }
        counts[i]++
    }
}
