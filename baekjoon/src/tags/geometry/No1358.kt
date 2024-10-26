package tags.geometry

/**
 * https://www.acmicpc.net/problem/1358
 */
fun main() {
    val (w, h, x, y, p) = readln().split(" ").map { it.toDouble() }
    val players = (0 until p.toInt()).map {
        val (px, py) = readln().split(" ").map { it.toDouble() }
        px to py
    }
    val count = players.count { isInBoundary(w, h, x, y, it) }
    println(count)
}

private fun isInBoundary(w: Double, h: Double, x: Double, y: Double, player: Pair<Double, Double>): Boolean {
    val (px, py) = player
    if (px in x..x + w && py in y..y + h) {
        return true
    }
    if (getDistance(x, y + h / 2, px, py) <= h * h / 4 || getDistance(x + w, y + h / 2, px, py) <= h * h / 4) {
        return true
    }
    return false
}

private fun getDistance(x: Double, y: Double, px: Double, py: Double) =
    (px - x) * (px - x) + (py - y) * (py - y)
