package tags.dp

/**
 * https://www.acmicpc.net/problem/2011
 */
fun main() {
    val code = readln()
    val numbers = code.toCharArray().map { it.digitToInt() }.toIntArray()
    if (isValid(numbers)) {
        println(getCount(numbers))
    } else {
        println(0)
    }
}

private fun isValid(numbers: IntArray): Boolean {
    if (numbers[0] == 0) {
        return false
    }
    for (i in 1 until numbers.size) {
        if (numbers[i - 1] * 10 + numbers[i] !in 1..26 && numbers[i] == 0) {
            return false
        }
    }
    return true
}

private fun getCount(numbers: IntArray): Int {
    val dp = IntArray(numbers.size)
    dp[0] = 1

    if (numbers.size >= 2) {
        dp[1] = if (numbers[0] * 10 + numbers[1] in 11..26 && numbers[1] != 0) {
            2
        } else {
            1
        }

        for (i in 2 until numbers.size) {
            if (numbers[i] != 0) {
                dp[i] = dp[i - 1]
            }
            if (numbers[i - 1] * 10 + numbers[i] in 10..26) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000
            }
        }
    }

    return dp.last()
}
