package tags.implementation

/**
 * https://www.acmicpc.net/problem/29790
 */
fun main() {
    val (n, u, l) = readln().split(" ").map { it.toInt() }
    val s = if (n >= 1000) {
        if (u >= 8000 || l >= 260) {
            "Very Good"
        } else {
            "Good"
        }
    } else {
        "Bad"
    }
    println(s)
}
