package tags.implementation

/**
 * https://www.acmicpc.net/problem/10812
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val baskets = IntArray(n + 1) { it }
    repeat(m) {
        val (i, j, k) = readln().split(" ").map { it.toInt() }
        val clone1 = baskets.copyOfRange(i, k)
        val clone2 = baskets.copyOfRange(k, j + 1)
        clone2.copyInto(baskets, i)
        clone1.copyInto(baskets, i + (j - k + 1))
    }
    println(baskets.drop(1).joinToString(" "))
}
