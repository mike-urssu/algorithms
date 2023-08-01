package tags.greedy

/**
 * https://www.acmicpc.net/problem/1041
 */
fun main() {
    val n = readln().toLong()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    val sum = if (n == 1L) {
        numbers.sum() - numbers.max()
    } else {
        val wall = n * n * 5L
        val wall3 = 4L
        val wall2 = 4 * (n - 2) * 2 + 4
        val wall1 = wall - wall3 * 3 - wall2 * 2
        getMin(numbers, wall1, wall2, wall3)
    }
    println(sum)
}

private fun getMin(numbers: IntArray, wall1: Long, wall2: Long, wall3: Long): Long {
    var sum = 0L
    sum += numbers.min() * wall1
    sum += getSumOfTwoWalls(numbers) * wall2
    sum += getSumOfThreeWalls(numbers) * wall3
    return sum
}

private fun getSumOfTwoWalls(numbers: IntArray) =
    intArrayOf(
        numbers[0] + numbers[1],
        numbers[0] + numbers[2],
        numbers[0] + numbers[3],
        numbers[0] + numbers[4],

        numbers[1] + numbers[0],
        numbers[1] + numbers[2],
        numbers[1] + numbers[3],
        numbers[1] + numbers[5],

        numbers[2] + numbers[0],
        numbers[2] + numbers[1],
        numbers[2] + numbers[4],
        numbers[2] + numbers[5],

        numbers[3] + numbers[0],
        numbers[3] + numbers[1],
        numbers[3] + numbers[4],
        numbers[3] + numbers[5],

        numbers[4] + numbers[0],
        numbers[4] + numbers[2],
        numbers[4] + numbers[3],
        numbers[4] + numbers[5],

        numbers[5] + numbers[1],
        numbers[5] + numbers[2],
        numbers[5] + numbers[3],
        numbers[5] + numbers[4]
    ).min()

private fun getSumOfThreeWalls(numbers: IntArray) =
    intArrayOf(
        numbers[0] + numbers[1] + numbers[2],
        numbers[0] + numbers[1] + numbers[3],
        numbers[0] + numbers[2] + numbers[4],
        numbers[0] + numbers[3] + numbers[4],

        numbers[5] + numbers[1] + numbers[2],
        numbers[5] + numbers[1] + numbers[3],
        numbers[5] + numbers[2] + numbers[4],
        numbers[5] + numbers[3] + numbers[4],
    ).min()
