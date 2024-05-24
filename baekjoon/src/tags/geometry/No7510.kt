package tags.geometry

/**
 * https://www.acmicpc.net/problem/7510
 */
fun main() {
    val n = readln().toInt()
    val result = StringBuilder()
    repeat(n) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }.sorted()
        result.append("Scenario #${it + 1}:\n")
        if (isRightTriangle(a, b, c)) {
            result.append("yes\n\n")
        } else {
            result.append("no\n\n")
        }
    }
    println(result.trim())
}

private fun isRightTriangle(a: Int, b: Int, c: Int) =
    c * c == a * a + b * b
