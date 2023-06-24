package tags.string

/**
 * https://www.acmicpc.net/problem/5789
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val s = readln()
        if (s[s.length / 2 - 1] == s[s.length / 2]) {
            println("Do-it")
        } else {
            println("Do-it-Not")
        }
    }
}
