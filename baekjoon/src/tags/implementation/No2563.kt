package tags.implementation

/**
 * https://www.acmicpc.net/problem/2563
 */
fun main() {
    val square = Array(100) { BooleanArray(100) }

    val n = readln().toInt()
    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() - 1 }
        (x until x + 10).forEach { i ->
            (y until y + 10).forEach { j ->
                square[i][j] = true
            }
        }
    }

    val area = square.sumOf { row -> row.count { it } }
    println(area)
}
