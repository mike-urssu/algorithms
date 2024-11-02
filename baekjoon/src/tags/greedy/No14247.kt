package tags.greedy

/**
 * https://www.acmicpc.net/problem/14247
 */
fun main() {
    readln()
    val heights = readln().split(" ").map { it.toLong() }
    val lengths = readln().split(" ").map { it.toLong() }.sorted()

    val sum = heights.sum() + lengths.mapIndexed { i, v -> v * i }.sum()
    println(sum)
}
