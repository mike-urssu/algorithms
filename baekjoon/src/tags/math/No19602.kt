package tags.math

/**
 * https://www.acmicpc.net/problem/19602
 */
fun main() {
    val s = readln().toInt()
    val m = readln().toInt()
    val l = readln().toInt()
    val score = s + 2 * m + 3 * l
    val output = if (score >= 10) {
        "happy"
    } else {
        "sad"
    }
    println(output)
}
