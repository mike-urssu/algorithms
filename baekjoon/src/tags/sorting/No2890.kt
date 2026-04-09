package tags.sorting

/**
 * https://www.acmicpc.net/problem/2890
 */
fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val graph = Array(r) { readln().toCharArray() }
    val ranking = IntArray(10) { -1 }
    var order = 1
    (c - 1 downTo 1).forEach { j ->
        var inc = false
        (0 until r).forEach { i ->
            if (graph[i][j] in '1'..'9') {
                val v = graph[i][j].digitToInt()
                if (ranking[v] == -1) {
                    inc = true
                    ranking[v] = order
                }
            }
        }
        if (inc) {
            order++
        }
    }
    (1..9).forEach { println(ranking[it]) }
}
