package tags.implementation

/**
 * https://www.acmicpc.net/problem/16967
 */
fun main() {
    val (h, w, x, y) = readln().split(" ").map { it.toInt() }
    val arrayB = Array(h + x) { readln().split(" ").map { it.toInt() }.toIntArray() }
    getArrayA(h, w, x, y, arrayB).forEach { println(it.joinToString(" ")) }
}

private fun getArrayA(h: Int, w: Int, x: Int, y: Int, arrayB: Array<IntArray>): Array<IntArray> {
    val arrayA = Array(h) { IntArray(w) }
    for (i in 0 until h + x) {
        for (j in 0 until w + y) {
            if (isInBoundaryA(i, j, h, w) && !isInBoundaryB(i, j, h, w, x, y)) {
                arrayA[i][j] = arrayB[i][j]
            } else if (!isInBoundaryA(i, j, h, w) && isInBoundaryB(i, j, h, w, x, y)) {
                arrayA[i - x][j - y] = arrayB[i][j]
            } else if (isInBoundaryA(i, j, h, w) && isInBoundaryB(i, j, h, w, x, y)) {
                arrayA[i][j] = arrayB[i][j] - arrayA[i - x][j - y]
            }
        }
    }
    return arrayA
}

private fun isInBoundaryA(row: Int, col: Int, h: Int, w: Int) =
    row in 0 until h && col in 0 until w

private fun isInBoundaryB(row: Int, col: Int, h: Int, w: Int, x: Int, y: Int) =
    row in x until h + x && col in y until w + y
