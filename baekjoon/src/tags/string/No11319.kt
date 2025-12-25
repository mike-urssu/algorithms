package tags.string

/**
 * https://www.acmicpc.net/problem/11319
 */
private val vowels = charArrayOf('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u')

fun main() {
    val s = readln().toInt()
    repeat(s) {
        val line = readln()
        val vowelCounts = line.count { it in vowels }
        val consonantCounts = line.count { it.isLetter() } - vowelCounts
        println("$consonantCounts $vowelCounts")
    }
}
