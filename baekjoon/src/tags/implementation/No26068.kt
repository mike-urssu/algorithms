package tags.implementation

/**
 * https://www.acmicpc.net/problem/26068
 */
fun main() {
    val n = readln().toInt()
    val count = (0 until n).count {
        val d = readln().split("-")[1].toInt()
        d <= 90
    }
    println(count)
}
