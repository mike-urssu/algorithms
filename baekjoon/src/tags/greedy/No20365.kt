package tags.greedy

/**
 * https://www.acmicpc.net/problem/20365
 */
fun main() {
    val n = readln().toInt()
    val colors = readln().toCharArray()

    var count = 1
    var color = colors[0]
    (1 until n).forEach { j ->
        if (colors[j] != color) {
            color = colors[j]
            count++
        }
    }
    println(count / 2 + 1)
}
