package tags.math

/**
 * https://www.acmicpc.net/problem/15781
 */
fun main() {
    readln()
    val helmet = readln().split(" ").maxOf { it.toInt() }
    val jacket = readln().split(" ").maxOf { it.toInt() }
    println(helmet + jacket)
}
