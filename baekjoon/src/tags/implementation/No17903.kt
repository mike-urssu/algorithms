package tags.implementation

/**
 * https://www.acmicpc.net/problem/17903
 */
fun main() {
    val (m, _) = readln().split(" ").map(String::toInt)
    repeat(m) { readln() }
    val v = if (m >= 8) {
        "satisfactory"
    } else {
        "unsatisfactory"
    }
    println(v)
}
