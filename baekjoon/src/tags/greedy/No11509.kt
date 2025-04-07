package tags.greedy

/**
 * https://www.acmicpc.net/problem/11509
 */
fun main() {
    readln()
    val heights = IntArray(1_000_001)
    val balloons = readln().split(" ").map { it.toInt() }.toIntArray()

    var count = 0
    balloons.forEach { h ->
        if (heights[h] == 0) {
            count++
        } else {
            heights[h]--
        }
        heights[h - 1]++
    }
    println(count)
}
