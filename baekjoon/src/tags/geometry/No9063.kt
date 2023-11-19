package tags.geometry

/**
 * https://www.acmicpc.net/problem/9063
 */
fun main() {
    val n = readln().toInt()
    var minX = 10000
    var maxX = -10000
    var minY = 10000
    var maxY = -10000
    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        minX = minX.coerceAtMost(x)
        maxX = maxX.coerceAtLeast(x)
        minY = minY.coerceAtMost(y)
        maxY = maxY.coerceAtLeast(y)
    }
    println((maxX - minX) * (maxY - minY))
}
