package tags.string

/**
 * https://www.acmicpc.net/problem/26546
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val input = readln().split(" ")
        val s = input[0]
        val (i, j) = input.drop(1).map { it.toInt() }
        println("${s.substring(0, i)}${s.substring(j)}")
    }
}
