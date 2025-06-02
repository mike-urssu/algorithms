package tags.dp

/**
 * https://www.acmicpc.net/problem/15489
 */
fun main() {
    val (r, c, w) = readln().split(" ").map { it.toInt() }
    val pascal = pascal()
    var sum = 0
    (r until r + w).forEachIndexed { i, x ->
        (0..i).forEach { y ->
            sum += pascal[x][c + y]
        }
    }
    println(sum)
}

private fun pascal(): Array<IntArray> {
    val pascal = Array(31) { IntArray(31) }
    (1..30).forEach { i ->
        (1..i).forEach { j ->
            pascal[i][j] = if (j == 1 || j == i) {
                1
            } else {
                pascal[i - 1][j - 1] + pascal[i - 1][j]
            }
        }
    }
    return pascal
}
