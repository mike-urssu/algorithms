package tags.dp

/**
 * https://www.acmicpc.net/problem/1509
 */
fun main() {
    val s = readln()
    val isPalindrome = isPalindrome("#$s")
    println(division(s.length + 1, isPalindrome))
}

private fun isPalindrome(s: String): Array<BooleanArray> {
    val palindrome = Array(s.length) { BooleanArray(s.length) }
    (1 until s.length).forEach { to ->
        (to downTo 1).forEach { from ->
            palindrome[from][to] = if (from == to) {
                true
            } else if (to - from == 1) {
                s[from] == s[to]
            } else {
                s[from] == s[to] && palindrome[from + 1][to - 1]
            }
        }
    }
    return palindrome
}

private fun division(size: Int, isPalindrome: Array<BooleanArray>): Int {
    val lengths = IntArray(size) { it }
    lengths[0] = 0
    (1 until size).forEach { to ->
        (1..to).forEach { from ->
            if (isPalindrome[from][to]) {
                lengths[to] = lengths[to].coerceAtMost(lengths[from - 1] + 1)
            }
        }
    }
    return lengths.last()
}
