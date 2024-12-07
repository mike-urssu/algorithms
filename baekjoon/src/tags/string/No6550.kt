package tags.string

/**
 * https://www.acmicpc.net/problem/6550
 */
fun main() {
    while (true) {
        val (s, t) = (readLine() ?: break).split(" ")
        if (isSubstring(s, t)) {
            println("Yes")
        } else {
            println("No")
        }
    }
}

private fun isSubstring(s: String, t: String): Boolean {
    if (s.length > t.length) {
        return false
    }

    var i = 0
    var j = 0
    while (i < s.length && j < t.length) {
        if (s[i] != t[j]) {
            j++
        } else {
            i++
            j++
        }
    }

    return i == s.length
}
