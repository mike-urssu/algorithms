package tags.string

/**
 * https://www.acmicpc.net/problem/1551
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val sequence = readln().split(",").map { it.toInt() }.toIntArray()
    var newSequence = sequence.copyOf()
    repeat(k) { i ->
        newSequence = getNewSequence(n - i - 1, newSequence)
    }
    println(newSequence.joinToString(","))
}

private fun getNewSequence(n: Int, sequence: IntArray) =
    IntArray(n) { i -> sequence[i + 1] - sequence[i] }
