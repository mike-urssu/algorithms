package tags.math

/**
 * https://www.acmicpc.net/problem/17269
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val (a, b) = readln().split(" ")

    var combination = getCombination(n, m, a, b)
    while (combination.size != 2) {
        combination = reduce(combination)
    }
    println("${combination[0] * 10 + combination[1]}%")
}

private val strokes = mapOf(
    'A' to 3, 'B' to 2, 'C' to 1, 'D' to 2, 'E' to 4, 'F' to 3, 'G' to 1, 'H' to 3, 'I' to 1, 'J' to 1,
    'K' to 3, 'L' to 1, 'M' to 3, 'N' to 2, 'O' to 1, 'P' to 2, 'Q' to 2, 'R' to 2, 'S' to 1, 'T' to 2,
    'U' to 1, 'V' to 1, 'W' to 1, 'X' to 2, 'Y' to 2, 'Z' to 1,
)

private fun getCombination(n: Int, m: Int, a: String, b: String): IntArray {
    val combination = IntArray(n + m)
    var i = 0
    var j = 0
    var k = 0
    while (i < n && j < m) {
        if (k % 2 == 0) {
            combination[k] = strokes[a[i++]]!!
        } else {
            combination[k] = strokes[b[j++]]!!
        }
        k++
    }
    while (i < n) {
        combination[k++] = strokes[a[i++]]!!
    }
    while (j < m) {
        combination[k++] = strokes[b[j++]]!!
    }
    return combination
}

private fun reduce(combination: IntArray): IntArray {
    val reduce = IntArray(combination.size - 1)
    for (i in reduce.indices) {
        reduce[i] = (combination[i] + combination[i + 1]) % 10
    }
    return reduce
}
