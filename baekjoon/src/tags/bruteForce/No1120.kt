package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1120
 */
fun main() {
    val (a, b) = readln().split(" ")
    val diff = b.length - a.length
    var min = Int.MAX_VALUE
    for (i in 0..diff) {
        min = min.coerceAtMost(getDifference(a, b.substring(i, i + a.length)))
    }
    println(min)
}

private fun getDifference(a: String, b: String): Int {
    var count = 0
    for (i in a.indices) {
        if (a[i] != b[i]) {
            count++
        }
    }
    return count
}
