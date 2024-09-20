package tags.string

/**
 * https://www.acmicpc.net/problem/20437
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val w = readln()
        val k = readln().toInt()
        val letters = getLetters(w)
        val shortestLength = getShortestLength(letters, k)
        val longestLength = getLongestLength(letters, k)

        if (shortestLength == -1 || longestLength == -1) {
            println(-1)
        } else {
            println("$shortestLength $longestLength")
        }
    }
}

private fun getLetters(w: String): Array<MutableList<Int>> {
    val letters = Array(26) { mutableListOf<Int>() }
    w.forEachIndexed { i, c -> letters[c - 'a'].add(i) }
    return letters
}

private fun getShortestLength(letters: Array<MutableList<Int>>, k: Int): Int {
    var shortestLength = Int.MAX_VALUE
    letters.forEach { indices ->
        if (indices.size >= k) {
            indices.windowed(k).forEach {
                shortestLength = shortestLength.coerceAtMost(it.last() - it.first() + 1)
            }
        }
    }
    if (shortestLength == Int.MAX_VALUE) {
        shortestLength = -1
    }
    return shortestLength
}

private fun getLongestLength(letters: Array<MutableList<Int>>, k: Int): Int {
    var longestLength = Int.MIN_VALUE
    letters.forEach { indices ->
        if (indices.size >= k) {
            indices.windowed(k).forEach {
                longestLength = longestLength.coerceAtLeast(it.last() - it.first() + 1)
            }
        }
    }
    if (longestLength == Int.MIN_VALUE) {
        longestLength = -1
    }
    return longestLength
}
