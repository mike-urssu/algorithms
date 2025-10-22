package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/5671
 */
fun main() {
    while (true) {
        val (n, m) = (readLine() ?: break).split(" ").map { it.toInt() }
        val count = (n..m).count { isLucky(it) }
        println(count)
    }
}

private fun isLucky(n: Int): Boolean {
    val counts = IntArray(10)
    var n = n
    while (n > 0) {
        val mod = n % 10
        if (counts[mod] != 0) {
            return false
        }
        counts[mod]++
        n /= 10
    }
    return true
}
