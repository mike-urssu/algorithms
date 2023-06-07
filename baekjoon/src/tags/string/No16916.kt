package tags.string

/**
 * https://www.acmicpc.net/problem/16916
 */
fun main() {
    val s = readln()
    val p = readln()
    if (kmp(s, p)) {
        println(1)
    } else {
        println(0)
    }
}

private fun kmp(s: String, p: String): Boolean {
    val pi = getPi(s)
    var j = 0
    for (i in s.indices) {
        while (j > 0 && s[i] != p[j]) {
            j = pi[j - 1]
        }
        if (s[i] == p[j]) {
            j++
        }
        if (j == p.length) {
            return true
        }
    }
    return false
}

private fun getPi(s: String): IntArray {
    val pi = IntArray(s.length)
    var j = 0
    for (i in 1 until s.length) {
        while (j > 0 && s[i] != s[j]) {
            j = pi[j - 1]
        }
        if (s[i] == s[j]) {
            pi[i] = ++j
        }
    }
    return pi
}
