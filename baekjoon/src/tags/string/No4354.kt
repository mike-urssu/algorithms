package tags.string

/**
 * https://www.acmicpc.net/problem/4354
 */
fun main() {
    while (true) {
        val s = readln()
        if (s == ".") {
            break
        }
        val pi = getPi(s)
        if (s.length % (s.length - pi.last()) != 0) {
            println(1)
        } else {
            println(s.length / (s.length - pi.last()))
        }
    }
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
