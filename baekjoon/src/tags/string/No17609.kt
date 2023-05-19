package tags.string

/**
 * https://www.acmicpc.net/problem/17609
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val s = readln()
        println(getPalindromeType(s))
    }
}

private fun getPalindromeType(s: String): Int {
    var left = 0
    var right = s.lastIndex
    while (left <= right) {
        if (s[left] != s[right]) {
            return if (isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1)) {
                1
            } else {
                2
            }
        }
        left++
        right--
    }
    return 0
}

private fun isPalindrome(s: String, left: Int, right: Int): Boolean {
    var leftIndex = left
    var rightIndex = right
    while (leftIndex <= rightIndex) {
        if (s[leftIndex] != s[rightIndex]) {
            return false
        }
        leftIndex++
        rightIndex--
    }
    return true
}
