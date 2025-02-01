package tags.string

/**
 * https://www.acmicpc.net/problem/13235
 */
fun main() {
    val s = readln()
    val isPalindrome = (0 until s.length / 2).all { s[it] == s[s.length - it - 1] }
    println(isPalindrome)
}
