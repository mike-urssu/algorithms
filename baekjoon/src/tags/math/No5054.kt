package tags.math

/**
 * https://www.acmicpc.net/problem/5054
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        readln()
        val positions = readln().split(" ").map { it.toInt() }.sorted()
        println((positions.last() - positions.first()) * 2)
    }
}
