package tags.binary_search

/**
 * https://www.acmicpc.net/problem/1166
 */
fun main() {
    val (n, l, w, h) = readln().split(" ").map { it.toInt() }
    println(findMaxA(n, l, w, h))
}

private fun findMaxA(n: Int, l: Int, w: Int, h: Int): Double {
    var low = 0.0
    var high = 1000000001.0
    repeat(1000) {
        val mid = (low + high) / 2
        if (isValid(n, l, w, h, mid)) {
            low = mid
        } else {
            high = mid
        }
    }
    return low
}

private fun isValid(n: Int, l: Int, w: Int, h: Int, a: Double) =
    (l / a).toLong() * (w / a).toLong() * (h / a).toLong() >= n.toLong()
