package tags.sorting

/**
 * https://www.acmicpc.net/problem/11256
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (j, n) = readln().split(" ").map { it.toInt() }
        val boxes = Array(n) {
            val (r, c) = readln().split(" ").map { it.toInt() }
            r to c
        }
        val sizes = boxes.map { (r, c) -> r * c }.sortedDescending()
        val prefixSum = sizes.runningFold(0, Int::plus)
        val index = prefixSum.indexOfFirst { it >= j }
        println(index)
    }
}
