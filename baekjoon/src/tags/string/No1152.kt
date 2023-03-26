package tags.string

/**
 * https://www.acmicpc.net/problem/1152
 */
fun main() {
    val count = readln()
        .split(" ")
        .filter { it.isNotEmpty() }
        .count { it.first() in ('a'..'z') || it.first() in ('A'..'Z') }
    println(count)
}
