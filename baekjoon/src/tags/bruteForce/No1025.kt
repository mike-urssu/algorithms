package tags.bruteForce

import kotlin.math.sqrt

/**
 * https://www.acmicpc.net/problem/1025
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val array = Array(n) { readln().toCharArray() }

    var max = -1
    for (i in 0 until n) {
        for (j in 0 until m) {
            for (rowStep in -n..n) {
                for (colStep in -m..m) {
                    max = max.coerceAtLeast(getMaxNumber(array, n, m, i, j, rowStep, colStep))
                }
            }
        }
    }

    println(max)
}

private fun getMaxNumber(array: Array<CharArray>, n: Int, m: Int, i: Int, j: Int, rowStep: Int, colStep: Int): Int {
    var max = -1

    if (rowStep == 0 && colStep == 0) {
        val number = array[i][j].digitToInt()
        if (isSquareNumber(number)) {
            max = max.coerceAtLeast(number)
        }
    } else {
        val str = StringBuilder()
        var row = i
        var col = j

        while (row in 0 until n && col in 0 until m) {
            str.append(array[row][col])
            row += rowStep
            col += colStep

            val number = str.toString().toInt()
            if (isSquareNumber(number)) {
                max = max.coerceAtLeast(number)
            }
        }
    }

    return max
}

private fun isSquareNumber(number: Int): Boolean {
    val sqrt = sqrt(number.toDouble()).toInt()
    return number == sqrt * sqrt
}
