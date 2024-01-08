package tags.implementation

/**
 * https://www.acmicpc.net/problem/2953
 */
fun main() {
    val scores = IntArray(5) { readln().split(" ").sumOf { it.toInt() } }
    val max = scores.max()
    println("${scores.indexOf(max) + 1} $max")
}
