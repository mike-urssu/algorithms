package tags.math

/**
 * https://www.acmicpc.net/problem/2765
 */
fun main() {
    var i = 1
    while (true) {
        val (radius, rotation, sec) = readln().split(" ").map { it.toDouble() }
        if (rotation == 0.0) {
            break
        }
        val distance = radius * Math.PI * rotation / 63360
        val mph = distance / sec * 3600
        println("Trip #${i++}: ${String.format("%.2f", distance)} ${String.format("%.2f", mph)}")
    }
}
