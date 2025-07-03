package tags.math

/**
 * https://www.acmicpc.net/problem/28938
 */
fun main() {
    readln()
    val directions = readln().split(" ").map { it.toInt() }
    val sum = directions.sum()
    val d = if (sum < 0) {
        "Left"
    } else if (sum == 0) {
        "Stay"
    } else {
        "Right"
    }
    println(d)
}
