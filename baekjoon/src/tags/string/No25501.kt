package tags.string

/**
 * https://www.acmicpc.net/problem/25501
 */
private var count = 0

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val s = readln()
        count = 0
        println("${isPalindrome(s)} $count")
    }
}

private fun isPalindrome(s: String) = recursion(s, 0, s.length - 1)

private fun recursion(s: String, l: Int, r: Int): Int {
    count++
    return if (l >= r) {
        1
    } else if (s[l] != s[r]) {
        0
    } else {
        recursion(s, l + 1, r - 1)
    }
}
