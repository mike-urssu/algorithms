package tags.implementation

/**
 * https://www.acmicpc.net/problem/30868
 */
fun main() {
    val t = readln().toInt()
    val candidates = IntArray(t) { readln().toInt() }
    candidates.forEach {
        println("${"++++ ".repeat(it / 5)}${"|".repeat(it % 5)}")
    }
}
