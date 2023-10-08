package tags.binary_search

/**
 * https://www.acmicpc.net/problem/8983
 */
fun main() {
    val (m, n, l) = readln().split(" ").map { it.toInt() }
    val xArray = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    val animals = Array(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        Pair(x, y)
    }

    val count = animals.count { canCatch(m, xArray, it, l) }
    println(count)
}

private fun canCatch(m: Int, xArray: IntArray, animal: Pair<Int, Int>, l: Int): Boolean {
    if (l - animal.second < 0) {
        return false
    }

    val boundary = animal.first - (l - animal.second)..animal.first + (l - animal.second)
    var low = -1
    var high = m
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (xArray[mid] < boundary.first) {
            low = mid
        } else if (xArray[mid] in boundary) {
            return true
        } else {
            high = mid
        }
    }
    return false
}
