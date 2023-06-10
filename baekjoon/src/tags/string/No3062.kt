package tags.string

/**
 * https://www.acmicpc.net/problem/3062
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln()
        val sum = n.toInt() + n.reversed().toInt()
        if (isPalindrome(sum.toString())) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

private fun isPalindrome(s: String): Boolean {
    val length = s.length
    for (i in 0 until length / 2) {
        if (s[i] != s[s.lastIndex - i]) {
            return false
        }
    }
    return true
}
