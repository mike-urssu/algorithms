package tags.math

/**
 * https://www.acmicpc.net/problem/10834
 */
fun main() {
    val m = readln().toInt()
    val wheels = Array(m) {
        readln().split(" ").map { it.toInt() }.toIntArray()
    }

    var isClockWise = true
    var rotation = 1
    wheels.forEach { (a, b, c) ->
        if (c == 1) {
            isClockWise = !isClockWise
        }
        val ratio = rotation / a
        rotation = b * ratio
    }

    if (isClockWise) {
        println("0 $rotation")
    } else {
        println("1 $rotation")
    }
}
