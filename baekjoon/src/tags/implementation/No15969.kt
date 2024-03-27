package tags.implementation

/**
 * https://www.acmicpc.net/problem/15969
 */
fun main() {
    readln()
    val scores = readln().split(" ").map { it.toInt() }.sorted()
    println(scores.last() - scores.first())
}
