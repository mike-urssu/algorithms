package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1356
 */
fun main() {
    val n = readln()
    if (isUNumber(n)) {
        println("YES")
    } else {
        println("NO")
    }
}

private fun isUNumber(n: String): Boolean {
    for (i in 1 until n.length) {
        var n1 = 1
        var n2 = 1

        n.substring(0, i).forEach { n1 *= it.digitToInt() }
        n.substring(i).forEach { n2 *= it.digitToInt() }

        if (n1 == n2) {
            return true
        }
    }
    return false
}
