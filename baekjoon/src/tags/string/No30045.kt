package tags.string

/**
 * https://www.acmicpc.net/problem/30045
 */
fun main() {
    val n = readln().toInt()
    val sentences = Array(n) { readln() }
    val count = sentences.count { "01" in it || "OI" in it }
    println(count)
}
