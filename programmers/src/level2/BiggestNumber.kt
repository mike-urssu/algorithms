package level2

class Solution {
    fun solution(numbers: IntArray): String {
        val sortedNumbers = numbers.sortedWith { it, other ->
            val itAsString = it.toString()
            val otherAsString = other.toString()
            -(itAsString + otherAsString).toInt().compareTo((otherAsString + itAsString).toInt())
        }

        val builder = StringBuilder()
        for (number in sortedNumbers)
            builder.append(number)
        val answer = builder.toString()
        return if (answer.startsWith('0'))
            "0"
        else answer
    }
}

fun main() {
    val solution = Solution()
    var numbers = intArrayOf(6, 10, 2)
    println(solution.solution(numbers))

    numbers = intArrayOf(3, 30, 34, 5, 9)
    println(solution.solution(numbers))

    numbers = intArrayOf(0, 0, 0)
    println(solution.solution(numbers))

    numbers = intArrayOf(0, 10, 100)
    println(solution.solution(numbers))
}