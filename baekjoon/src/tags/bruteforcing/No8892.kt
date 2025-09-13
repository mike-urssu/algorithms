package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/8892
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val k = readln().toInt()
        val words = Array(k) { readln() }

        var isPalindrome = false
        var palindrome = ""
        for (i in 0 until k) {
            for (j in 0 until k) {
                if (i != j) {
                    val word = words[i] + words[j]
                    if (isPalindrome(word)) {
                        isPalindrome = true
                        palindrome = word
                    }
                }
            }
        }
        if (isPalindrome) {
            println(palindrome)
        } else {
            println(0)
        }
    }
}

private fun isPalindrome(word: String): Boolean {
    return (0 until word.length / 2).all { i ->
        word[i] == word[word.lastIndex - i]
    }
}
