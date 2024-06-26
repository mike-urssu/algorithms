package tags.implementation

/**
 * https://www.acmicpc.net/problem/20053
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        readln()
        val numbers = readln().split(" ").map { it.toInt() }
        println("${numbers.min()} ${numbers.max()}")
    }
}
