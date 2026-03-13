package tags.string

/**
 * https://www.acmicpc.net/problem/16172
 */
fun main() {
    val s = readln()
    val k = readln()
    println(kmpSearch(s, k))
}

private fun makePi(pattern: String): IntArray {
    val pi = IntArray(pattern.length)
    var j = 0

    for (i in 1 until pattern.length) {
        while (j > 0 && pattern[i] != pattern[j]) {
            j = pi[j - 1]
        }

        if (pattern[i] == pattern[j]) {
            j++
            pi[i] = j
        }
    }

    return pi
}

private fun kmpSearch(s: String, k: String): Int {
    val pi = makePi(k)
    var j = 0

    for (c in s) {
        if (c.isDigit()) {
            continue
        }

        while (j > 0 && c != k[j]) {
            j = pi[j - 1]
        }

        if (c == k[j]) {
            if (j == k.length - 1) {
                return 1
            }
            j++
        }
    }

    return 0
}
