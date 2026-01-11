package tags.bfs

/**
 * https://www.acmicpc.net/problem/17204
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val pointer = IntArray(n) { readln().toInt() }

    val orders = IntArray(n)
    var cur = 0
    while (true) {
        val next = pointer[cur]
        if (next == 0 || orders[next] != 0) {
            break
        }
        if (orders[next] == 0) {
            orders[next] = orders[cur] + 1
        }
        cur = next
    }

    val m = if (orders[k] == 0) {
        -1
    } else {
        orders[k]
    }
    println(m)
}
