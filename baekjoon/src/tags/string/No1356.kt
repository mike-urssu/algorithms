package tags.string

/**
 * https://www.acmicpc.net/problem/1356
 */
fun main() {
    val n = readln()
    if (isValid(n)) {
        println("YES")
    } else {
        println("NO")
    }
}

private fun isValid(n: String): Boolean {
    for (i in 1..n.lastIndex) {
        val a = n.substring(0, i).map { it.digitToInt() }.reduce { acc, digit -> acc * digit }
        val b = n.substring(i).map { it.digitToInt() }.reduce { acc, digit -> acc * digit }
        if (a == b) {
            return true
        }
    }
    return false
}
