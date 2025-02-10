package tags.string

/**
 * https://www.acmicpc.net/problem/10174
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val s = readln()
        val isPalindrome = if (isPalindrome(s.lowercase())) {
            "Yes"
        } else {
            "No"
        }
        println(isPalindrome)
    }
}

private fun isPalindrome(s: String) =
    (0 until s.length / 2).all { i -> s[i] == s[s.lastIndex - i] }
