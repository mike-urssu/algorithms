package tags.bfs

/**
 * https://www.acmicpc.net/problem/10451
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val numbers = IntArray(n + 1).apply {
            readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
        }
        println(countCycles(n, numbers))
    }
}

private fun countCycles(n: Int, numbers: IntArray): Int {
    var cycles = 0
    val isVisited = BooleanArray(n + 1)
    (1..n).forEach { i ->
        var src = i
        if (!isVisited[src]) {
            while (true) {
                if (!isVisited[src]) {
                    isVisited[src] = true
                    src = numbers[src]
                } else {
                    cycles++
                    break
                }
            }
        }
    }
    return cycles
}
