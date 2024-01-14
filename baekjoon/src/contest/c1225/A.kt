package contest.c1225

/**
 * https://www.acmicpc.net/contest/problem/1225/1
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val pricesA = IntArray(n)
    val pricesB = IntArray(n)
    repeat(n) { i ->
        val (a, b) = readln().split(" ").map { it.toInt() }
        pricesA[i] = a
        pricesB[i] = b
    }

    println(getX(n, pricesA, pricesB, k))
}

private fun getX(n: Int, pricesA: IntArray, pricesB: IntArray, k: Int): Int {
    var low = -1
    var high = 1_000_000_000

    while (low + 1 < high) {
        val mid = (low + high) shr 1
        val count = (0 until n).count { i -> pricesA[i] + mid >= pricesB[i] }
        if (count >= k) {
            high = mid
        } else {
            low = mid
        }
    }

    return high
}
