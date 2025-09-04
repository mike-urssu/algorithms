package tags.string

/**
 * https://www.acmicpc.net/problem/17249
 */
fun main() {
    val s = readln()
    val (left, right) = s.split("(^0^)").map { it.count { it == '@' } }
    println("$left $right")
}
