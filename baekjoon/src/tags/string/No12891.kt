package tags.string

/**
 * https://www.acmicpc.net/problem/12891
 */
fun main() {
    val (s, p) = readln().split(" ").map { it.toInt() }
    val dna = readln()
    val (a, c, g, t) = readln().split(" ").map { it.toInt() }

    val counts = IntArray(4)
    var count = 0

    (0 until p).forEach { i -> increaseCount(counts, dna[i]) }
    if (isValid(counts, a, c, g, t)) {
        count++
    }

    for (i in 0 until s - p) {
        increaseCount(counts, dna[i + p])
        decreaseCount(counts, dna[i])
        if (isValid(counts, a, c, g, t)) {
            count++
        }
    }

    println(count)
}

private fun increaseCount(counts: IntArray, c: Char) {
    when (c) {
        'A' -> counts[0]++
        'C' -> counts[1]++
        'G' -> counts[2]++
        'T' -> counts[3]++
    }
}

private fun decreaseCount(counts: IntArray, c: Char) {
    when (c) {
        'A' -> counts[0]--
        'C' -> counts[1]--
        'G' -> counts[2]--
        'T' -> counts[3]--
    }
}

private fun isValid(counts: IntArray, a: Int, c: Int, g: Int, t: Int) =
    counts[0] >= a && counts[1] >= c && counts[2] >= g && counts[3] >= t
