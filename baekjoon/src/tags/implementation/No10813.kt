package tags.implementation

/**
 * https://www.acmicpc.net/problem/10813
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val baskets = IntArray(n) { it + 1 }
    repeat(m) {
        val (i, j) = readln().split(" ").map { it.toInt() - 1 }
        swap(baskets, i, j)
    }
    println(baskets.joinToString(" "))
}

private fun swap(baskets: IntArray, i: Int, j: Int) {
    val temp = baskets[i]
    baskets[i] = baskets[j]
    baskets[j] = temp
}
