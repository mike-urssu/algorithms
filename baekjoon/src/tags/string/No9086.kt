package tags.string

/**
 * https://www.acmicpc.net/problem/9086
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val s = readln()
        println("${s.first()}${s.last()}")
    }
}
