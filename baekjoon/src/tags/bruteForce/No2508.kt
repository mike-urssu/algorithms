package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/2508
 */
fun main() {
    val testCase = readln().toInt()
    repeat(testCase) {
        readln()
        val (r, _) = readln().split(" ").map { it.toInt() }
        val box = Array(r) { readln().toCharArray() }
        val candies = countCandies(box)
        println(candies)
    }
}

private fun countCandies(box: Array<CharArray>): Int {
    var count = 0
    for (i in box.indices) {
        for (j in box[i].indices) {
            if (box[i][j] == 'o' && containsCandy(box, i, j)) {
                count++
            }
        }
    }
    return count
}

private fun containsCandy(box: Array<CharArray>, row: Int, col: Int): Boolean {
    if (row in 1 until box.size - 1 && (col == 0 || col == box[0].size - 1)) {
        if (box[row - 1][col] == 'v' && box[row + 1][col] == '^') {
            return true
        }
    }
    if (col in 1 until box[0].size - 1 && (row == 0 || row == box.size - 1)) {
        if (box[row][col - 1] == '>' && box[row][col + 1] == '<') {
            return true
        }
    }
    if (row in 1 until box.size - 1 && col in 1 until box[0].size - 1) {
        return (box[row - 1][col] == 'v' && box[row + 1][col] == '^') || (box[row][col - 1] == '>' && box[row][col + 1] == '<')
    }
    return false
}
