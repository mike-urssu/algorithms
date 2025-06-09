package tags.math

/**
 * https://www.acmicpc.net/problem/11068
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        if (isPalindrome(n)) {
            println(1)
        } else {
            println(0)
        }
    }
}

private fun isPalindrome(n: Int): Boolean {
    return (2..64).any { b ->
        val digits = mutableListOf<Int>()
        var remainder = n
        while (remainder >= b) {
            digits.add(remainder % b)
            remainder /= b
        }
        digits.add(remainder)
        (0 until digits.size / 2).all { i -> digits[i] == digits[digits.lastIndex - i] }
    }
}
