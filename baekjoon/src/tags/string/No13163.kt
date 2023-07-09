package tags.string

/**
 * https://www.acmicpc.net/problem/13163
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val s = readln()
        val words = s.split(" ").drop(1)
        println("god${words.joinToString("")}")
    }
}
