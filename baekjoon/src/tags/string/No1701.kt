package tags.string

/**
 * https://www.acmicpc.net/problem/1701
 */
fun main() {
    val s = readln()
    val max = s.indices.maxOf { i ->
        val substring = s.substring(i, s.length)
        getPi(substring).max()
    }
    println(max)
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
