package tags.string

/**
 * https://www.acmicpc.net/problem/10953
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        println(readln().split(",").sumOf { it.toInt() })
    }
}
