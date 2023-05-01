package tags.string

/**
 * https://www.acmicpc.net/problem/5988
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val s = readln()
        if (s.last().digitToInt() % 2 == 0) {
            println("even")
        } else {
            println("odd")
        }
    }
}
