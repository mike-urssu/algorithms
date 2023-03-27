package tags.string

/**
 * https://www.acmicpc.net/problem/10610
 */
fun main() {
    val n = readln()
    if (!n.contains("0") || n.sumOf { it.digitToInt() } % 3 != 0) {
        println(-1)
    } else {
        println(n.toCharArray().sortedDescending().joinToString(""))
    }
}
