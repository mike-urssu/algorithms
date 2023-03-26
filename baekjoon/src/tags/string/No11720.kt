package tags.string

/**
 * https://www.acmicpc.net/problem/11720
 */
fun main() {
    readln()
    val sum = readln().toCharArray().sumOf { it.digitToInt() }
    println(sum)
}
