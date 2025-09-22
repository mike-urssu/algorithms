package tags.math

/**
 * https://www.acmicpc.net/problem/6502
 */
fun main() {
    var i = 1
    while (true) {
        val s = readln()
        if (s == "0") {
            break
        }

        val (r, w, l) = s.split(" ").map { it.toInt() }
        if (4 * r * r >= w * w + l * l) {
            println("Pizza ${i++} fits on the table.")
        } else {
            println("Pizza ${i++} does not fit on the table.")
        }
    }
}
