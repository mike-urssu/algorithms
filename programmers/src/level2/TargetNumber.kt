package level2

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */
class TargetNumber {
    private var count = 0

    fun solution(numbers: IntArray, target: Int): Int {
        count = 0
        dfs(numbers, target, 0, 0)
        return count
    }

    private fun dfs(numbers: IntArray, target: Int, index: Int, sum: Int) {
        if (index == numbers.size) {
            if (target == sum)
                count++
            return
        }
        dfs(numbers, target, index + 1, sum + numbers[index])
        dfs(numbers, target, index + 1, sum - numbers[index])
    }
}

fun main() {
    val targetNumber = TargetNumber()
    var numbers = intArrayOf(1, 1, 1, 1, 1)
    var target = 3
    println(targetNumber.solution(numbers, target) == 5)

    numbers = intArrayOf(4, 1, 2, 1)
    target = 4
    println(targetNumber.solution(numbers, target) == 2)
}