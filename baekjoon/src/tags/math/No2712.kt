package tags.math

/**
 * https://www.acmicpc.net/problem/2712
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val input = readln().split(" ")
        val v = input[0].toDouble()
        val unit = input[1]

        val s = when (unit) {
            "kg" -> "${String.format("%.4f", v * 2.2046)} lb"
            "lb" -> "${String.format("%.4f", v * 0.4536)} kg"
            "l" -> "${String.format("%.4f", v * 0.2642)} g"
            else -> "${String.format("%.4f", v * 3.7854)} l"
        }
        println(s)
    }
}
