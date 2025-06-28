package tags.implementation

/**
 * https://www.acmicpc.net/problem/8911
 */
private val dx = intArrayOf(0, -1, 0, 1)
private val dy = intArrayOf(1, 0, -1, 0)

fun main() {
    val t = readln().toInt()
    repeat(t) {
        var x = 0
        var y = 0
        var k = 0
        var minX = 0
        var minY = 0
        var maxX = 0
        var maxY = 0
        val orders = readln()
        orders.forEach { c ->
            when (c) {
                'F' -> {
                    x += dx[k]
                    y += dy[k]
                    minX = minOf(minX, x)
                    minY = minOf(minY, y)
                    maxX = maxOf(maxX, x)
                    maxY = maxOf(maxY, y)
                }

                'B' -> {
                    x -= dx[k]
                    y -= dy[k]
                    minX = minOf(minX, x)
                    minY = minOf(minY, y)
                    maxX = maxOf(maxX, x)
                    maxY = maxOf(maxY, y)
                }

                'L' -> k = (k + 3) % 4
                'R' -> k = (k + 1) % 4
            }
        }
        println((maxX - minX) * (maxY - minY))
    }
}
