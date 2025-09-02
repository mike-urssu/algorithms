package tags.string

/**
 * https://www.acmicpc.net/problem/17350
 */
fun main() {
    val n = readln().toInt()
    val names = Array(n) { readln() }
    if ("anj" in names) {
        println("뭐야;")
    } else {
        println("뭐야?")
    }
}
