package tags.implementation

/**
 * https://www.acmicpc.net/problem/2445
 */
fun main() {
    val n = readln().toInt()
    println(getStars(n))
}

private fun getStars(n: Int): String {
    val stars = StringBuilder()
    for (i in 1..n) {
        stars.append("*".repeat(i))
        stars.append("  ".repeat(n - i))
        stars.append("*".repeat(i))
        stars.append("\n")
    }
    for (i in 1 until n) {
        stars.append("*".repeat(n - i))
        stars.append("  ".repeat(i))
        stars.append("*".repeat(n - i))
        stars.append("\n")
    }
    return stars.toString()
}
