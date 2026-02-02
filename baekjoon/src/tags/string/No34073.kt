package tags.string

/**
 * https://www.acmicpc.net/problem/34073
 */
fun main() {
    readln()
    val s = readln()
    println(s.split(" ").joinToString(" ") { "${it}DORO" })
}
