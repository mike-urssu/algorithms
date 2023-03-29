package tags.string

/**
 * https://www.acmicpc.net/problem/1100
 */
fun main() {
    val board = Array(8) { readln().toCharArray() }
    var count = 0
    for (i in 0 until 8) {
        for (j in 0 until 8) {
            if ((i + j) % 2 == 0 && board[i][j] == 'F') {
                count++
            }
        }
    }
    println(count)
}
