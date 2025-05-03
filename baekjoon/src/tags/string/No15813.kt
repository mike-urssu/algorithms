package tags.string

/**
 * https://www.acmicpc.net/problem/15813
 */
fun main() {
    readln()
    val name = readln()
    println(name.sumOf { it - 'A' + 1 })
}
