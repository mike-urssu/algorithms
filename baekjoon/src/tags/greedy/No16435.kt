package tags.greedy

/**
 * https://www.acmicpc.net/problem/16435
 */
fun main() {
    val (_, l) = readln().split(" ").map { it.toInt() }
    val heights = readln().split(" ").map { it.toInt() }.sorted()
    var currentHeight = l
    heights.forEach { height ->
        if (currentHeight >= height) {
            currentHeight++
        }
    }
    println(currentHeight)
}
