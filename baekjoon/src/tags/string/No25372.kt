package tags.string

/**
 * https://www.acmicpc.net/problem/25372
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val s = readln()
        if (s.length in 6..9) {
            println("yes")
        } else {
            println("no")
        }
    }
}
