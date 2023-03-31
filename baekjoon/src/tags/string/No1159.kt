package tags.string

/**
 * https://www.acmicpc.net/problem/1159
 */
fun main() {
    val n = readln().toInt()
    val names = Array(n) { readln() }
    val group = names.groupBy { it.first() }
    val candidates = group.filterValues { it.size >= 5 }.keys
    if (candidates.isNotEmpty()) {
        println(candidates.sorted().joinToString(""))
    } else {
        println("PREDAJA")
    }
}
