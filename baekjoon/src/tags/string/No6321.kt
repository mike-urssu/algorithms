package tags.string

/**
 * https://www.acmicpc.net/problem/6321
 */
fun main() {
    val alphabets = ('A'..'Z').toList()
    val n = readln().toInt()
    repeat(n) { i ->
        val s = readln()
        println("String #${i + 1}")
        s.forEach { print(alphabets[(alphabets.indexOf(it) + 1) % 26]) }
        println()
        println()
    }
}
