package tags.geometry

/**
 * https://www.acmicpc.net/problem/9366
 */
fun main() {
    val t = readln().toInt()
    repeat(t) { i ->
        val (a, b, c) = readln().split(" ").map { it.toInt() }.sorted()
        val type = if (a + b <= c) {
            "invalid!"
        } else if (a == b && b == c) {
            "equilateral"
        } else if (a == b || b == c) {
            "isosceles"
        } else {
            "scalene"
        }
        println("Case #${i + 1}: $type")
    }
}
