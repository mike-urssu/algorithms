package tags.implementation

/**
 * https://www.acmicpc.net/problem/9699
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val weights = readln().split(" ").map { it.toInt() }
        println("Case #${it + 1}: ${weights.max()}")
    }
}
