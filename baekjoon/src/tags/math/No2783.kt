package tags.math

/**
 * https://www.acmicpc.net/problem/2783
 */
fun main() {
    val pricesPerWeight = mutableListOf<Pair<Int, Int>>()
    val (x, y) = readln().split(" ").map { it.toInt() }
    pricesPerWeight.add(x to y)
    val n = readln().toInt()
    repeat(n) {
        val (xi, yi) = readln().split(" ").map { it.toInt() }
        pricesPerWeight.add(xi to yi)
    }
    val minPrice = pricesPerWeight.minOf { (price, weight) -> price / weight.toDouble() * 1000 }
    println(String.format("%.2f", minPrice))
}
