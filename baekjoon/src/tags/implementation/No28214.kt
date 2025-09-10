package tags.implementation

/**
 * https://www.acmicpc.net/problem/28214
 */
fun main() {
    val (_, k, p) = readln().split(" ").map { it.toInt() }
    val breads = readln().split(" ").map { it.toInt() }
    val count = breads.chunked(k).count { chunk -> chunk.count { it == 0 } < p }
    println(count)
}
