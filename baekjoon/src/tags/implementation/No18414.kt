package tags.implementation

/**
 * https://www.acmicpc.net/problem/18414
 */
fun main() {
    val (x, l, r) = readln().split(" ").map { it.toInt() }
    val n = if (x < l) {
        l
    } else if (x in l..r) {
        x
    } else {
        r
    }
    println(n)
}
