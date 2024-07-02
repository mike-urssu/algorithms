package tags.implementation

/**
 * https://www.acmicpc.net/problem/1592
 */
fun main() {
    val (n, m, l) = readln().split(" ").map { it.toInt() }
    var v = 1
    val counts = IntArray(n + 1).apply { this[v] = 1 }
    var count = 0
    while (true) {
        if (counts[v] == m) {
            break
        }
        v = if (counts[v] % 2 == 1) {
            (v + l) % n
        } else {
            (v + n - l) % n
        }
        if (v == 0) {
            v = n
        }
        counts[v]++
        count++
    }
    println(count)
}
