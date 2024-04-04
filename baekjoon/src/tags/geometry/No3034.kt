package tags.geometry

/**
 * https://www.acmicpc.net/problem/3034
 */
fun main() {
    val (n, w, h) = readln().split(" ").map { it.toInt() }
    repeat(n) {
        val l = readln().toInt()
        if (w * w + h * h >= l * l) {
            println("DA")
        } else {
            println("NE")
        }
    }
}
