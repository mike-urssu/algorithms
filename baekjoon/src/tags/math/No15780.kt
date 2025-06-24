package tags.math

/**
 * https://www.acmicpc.net/problem/15780
 */
fun main() {
    val (n, _) = readln().split(" ").map { it.toInt() }
    val holes = readln().split(" ").map { it.toInt() }.toIntArray()
    val max = holes.sumOf { (it + 1) / 2 }
    if (max >= n) {
        println("YES")
    } else {
        println("NO")
    }
}
