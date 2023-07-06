package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1254
 */
fun main() {
    val s = readln()
    for (i in s.indices) {
        val string = s.substring(i)
        if (isPalindrome(string)) {
            println(string.length + i * 2)
            return
        }
    }
    println(s.length * 2 - 1)
}

private fun isPalindrome(string: String): Boolean {
    for (i in 0 until string.length / 2) {
        if (string[i] != string[string.lastIndex - i]) {
            return false
        }
    }
    return true
}
