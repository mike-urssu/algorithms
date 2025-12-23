package tags.implementation

/**
 * https://www.acmicpc.net/problem/23808
 */
fun main() {
    val n = readln().toInt()
    val stars = "@".repeat(n)
    val blanks = " ".repeat(n)
    repeat(2 * n) { println("$stars${blanks.repeat(3)}$stars") }
    repeat(n) { println(stars.repeat(5)) }
    repeat(n) { println("$stars${blanks.repeat(3)}$stars") }
    repeat(n) { println(stars.repeat(5)) }
}
