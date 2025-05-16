package tags.geometry

/**
 * https://www.acmicpc.net/problem/22938
 */
fun main() {
    val (x1, y1, r1) = readln().split(" ").map { it.toBigInteger() }
    val (x2, y2, r2) = readln().split(" ").map { it.toBigInteger() }
    val isWrapped = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) < (r1 + r2) * (r1 + r2)
    if (isWrapped) {
        println("YES")
    } else {
        println("NO")
    }
}
