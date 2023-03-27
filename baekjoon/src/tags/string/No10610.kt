package tags.string

/**
 * https://www.acmicpc.net/problem/10610
 */
fun main() {
    val n = readln().toCharArray().sortedDescending().joinToString("")
    if (!n.endsWith("0") || n.sumOf { it.digitToInt() } % 3 != 0) {
        println(-1)
    } else {
        println(n)
    }
}
