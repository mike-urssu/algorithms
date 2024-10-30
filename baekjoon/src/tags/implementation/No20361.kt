package tags.implementation

/**
 * https://www.acmicpc.net/problem/20361
 */
fun main() {
    val (_, x, k) = readln().split(" ").map { it.toInt() }
    var index = x
    repeat(k) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (index == a) {
            index = b
        } else if (index == b) {
            index = a
        }
    }
    println(index)
}
