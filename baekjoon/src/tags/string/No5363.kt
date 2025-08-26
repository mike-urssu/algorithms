package tags.string

/**
 * https://www.acmicpc.net/problem/5363
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val s = readln()
        val words = s.split(" ")
        println("${words.takeLast(words.size - 2).joinToString(" ")} ${words.take(2).joinToString(" ")}")
    }
}
