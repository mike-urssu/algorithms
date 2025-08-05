package tags.implementation

/**
 * https://www.acmicpc.net/problem/11637
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val candidates = IntArray(n) { readln().toInt() }
        val max = candidates.max()
        val maxCount = candidates.count { it == max }
        val result = if (maxCount > 1) {
            "no winner"
        } else {
            if (max > candidates.sum() / 2) {
                "majority winner ${candidates.indexOf(max) + 1}"
            } else {
                "minority winner ${candidates.indexOf(max) + 1}"
            }
        }
        println(result)
    }
}
