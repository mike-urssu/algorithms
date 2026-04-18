package tags.math

/**
 * https://www.acmicpc.net/problem/34945
 */
fun main() {
    val x = readln().toInt()
    val v = if (x >= 6) {
        "Success!"
    } else {
        "Oh My God!"
    }
    println(v)
}
