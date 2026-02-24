package tags.string

/**
 * https://www.acmicpc.net/problem/23080
 */
fun main() {
    val k = readln().toInt()
    val s = readln()
    println(s.chunked(k).map { it[0] }.joinToString(""))
}
