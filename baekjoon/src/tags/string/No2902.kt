package tags.string

/**
 * https://www.acmicpc.net/problem/2902
 */
fun main() {
    val name = readln().split("-")
        .map { it.first() }
        .joinToString("")
    println(name)
}
