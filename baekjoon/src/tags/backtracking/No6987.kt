package tags.backtracking

/**
 * https://www.acmicpc.net/problem/6987
 */
private val matches = getMatches()
private var isValid = false
private lateinit var scores: List<IntArray>

fun main() {
    val result = (0 until 4).map {
        scores = readln().split(" ").map { it.toInt() }.chunked(3).map { it.toIntArray() }
        isValid = false
        if (isValid()) {
            1
        } else {
            0
        }
    }.joinToString(" ")
    println(result)
}

private fun getMatches(): List<Pair<Int, Int>> {
    val matches = mutableListOf<Pair<Int, Int>>()
    (0 until 6).forEach { i ->
        (i + 1 until 6).forEach { j ->
            matches.add(i to j)
        }
    }
    return matches
}

private fun isValid(): Boolean {
    match(0)
    return isValid
}

private fun match(r: Int) {
    if (r == 15) {
        if (scores.all { row -> row.all { it == 0 } }) {
            isValid = true
        }
        return
    }

    val (src, dst) = matches[r]
    if (scores[src][1] > 0 && scores[dst][1] > 0) {
        scores[src][1]--
        scores[dst][1]--
        match(r + 1)
        scores[src][1]++
        scores[dst][1]++
    }

    if (scores[src][2] > 0 && scores[dst][0] > 0) {
        scores[src][2]--
        scores[dst][0]--
        match(r + 1)
        scores[src][2]++
        scores[dst][0]++
    }

    if (scores[src][0] > 0 && scores[dst][2] > 0) {
        scores[src][0]--
        scores[dst][2]--
        match(r + 1)
        scores[src][0]++
        scores[dst][2]++
    }
}
