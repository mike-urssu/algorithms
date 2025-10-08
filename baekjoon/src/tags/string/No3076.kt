package tags.string

/**
 * https://www.acmicpc.net/problem/3076
 */
fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val (a, b) = readln().split(" ").map { it.toInt() }

    val graph = Array(r * a) { CharArray(c * b) { '.' } }
    for (i in 0 until r) {
        for (j in 0 until c) {
            if ((i + j) % 2 == 0) {
                for (i2 in 0 until a) {
                    for (j2 in 0 until b) {
                        graph[i * a + i2][j * b + j2] = 'X'
                    }
                }
            }
        }
    }

    graph.forEach { println(it.joinToString("")) }
}
