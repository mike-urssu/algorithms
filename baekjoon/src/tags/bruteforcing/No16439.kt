package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/16439
 */
private lateinit var favors: Array<IntArray>
private lateinit var combination: IntArray
private var max = 0

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    favors = Array(n) { readln().split(" ").map(String::toInt).toIntArray() }
    combination = IntArray(3)
    combination(n, m, 0, 0)
    println(max)
}

private fun combination(n: Int, m: Int, r: Int, v: Int) {
    if (r == 3) {
        val sum = (0 until n).sumOf { k -> combination.maxOf { i -> favors[k][i] } }
        max = maxOf(max, sum)
        return
    }

    (v until m).forEach { i ->
        combination[r] = i
        combination(n, m, r + 1, i + 1)
    }
}
