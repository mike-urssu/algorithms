package tags.greedy

/**
 * https://www.acmicpc.net/problem/1141
 */
fun main() {
    val n = readln().toInt()
    val words = Array(n) { readln() }.sortedByDescending { it.length }
    val group = mutableListOf<String>()
    for (word in words) {
        if (group.all { !it.startsWith(word) }) {
            group.add(word)
        }
    }
    println(group.size)
}
