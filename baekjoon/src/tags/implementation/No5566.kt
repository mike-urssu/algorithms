package tags.implementation

/**
 * https://www.acmicpc.net/problem/5566
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val movements = IntArray(n) { readln().toInt() }
    val dices = IntArray(m) { readln().toInt() }
    var index = 0
    var c = 0
    for (d in dices) {
        index += d
        c++
        if (index >= n - 1) {
            break
        }
        index += movements[index]
        if (index >= n - 1) {
            break
        }
    }
    println(c)
}
