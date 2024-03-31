package tags.implementation

/**
 * https://www.acmicpc.net/problem/4562
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        if (x >= y) {
            println("MMM BRAINS")
        } else {
            println("NO BRAINS")
        }
    }
}
