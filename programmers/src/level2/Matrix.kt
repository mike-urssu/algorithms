package level2

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12949
 */
class Matrix {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val height1 = arr1.size
        val width2 = arr2[0].size

        val array = Array(height1) { IntArray(width2) }
        for (i in 0 until height1) {
            for (j in 0 until width2) {
                for (k in arr2.indices)
                    array[i][j] += arr1[i][k] * arr2[k][j]
            }
        }
        return array
    }
}

fun main() {
    val matrix = Matrix()
    var arr1 = arrayOf(intArrayOf(1, 4), intArrayOf(3, 2), intArrayOf(4, 1))
    var arr2 = arrayOf(intArrayOf(3, 3), intArrayOf(3, 3))
    println(
        matrix.solution(arr1, arr2) contentDeepEquals
                arrayOf(intArrayOf(15, 15), intArrayOf(15, 15), intArrayOf(15, 15))
    )

    arr1 = arrayOf(intArrayOf(2, 3, 2), intArrayOf(4, 2, 4), intArrayOf(3, 1, 4))
    arr2 = arrayOf(intArrayOf(5, 4, 3), intArrayOf(2, 4, 1), intArrayOf(3, 1, 1))
    println(
        matrix.solution(arr1, arr2) contentDeepEquals
                arrayOf(intArrayOf(22, 22, 11), intArrayOf(36, 28, 18), intArrayOf(29, 20, 14))
    )
}
