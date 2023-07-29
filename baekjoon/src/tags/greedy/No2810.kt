package tags.greedy

/**
 * https://www.acmicpc.net/problem/2810
 */
fun main() {
    val n = readln().toInt()
    val s = readln()
    val cupHolders = s.replace("LL", "S").length + 1
    println(n.coerceAtMost(cupHolders))
}
