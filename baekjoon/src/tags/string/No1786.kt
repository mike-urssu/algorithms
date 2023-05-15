package tags.string

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1786
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val t = reader.readLine()
    val p = reader.readLine()

    val indices = kmp(t, p)

    writer.write("${indices.size}\n")
    indices.forEach { writer.write("$it\n") }
    writer.flush()
}

private fun kmp(s: String, p: String): List<Int> {
    val pi = getPi(p)

    val indices = mutableListOf<Int>()
    var j = 0
    for (i in s.indices) {
        while (j > 0 && s[i] != p[j]) {
            j = pi[j - 1]
        }
        if (s[i] == p[j]) {
            if (j == p.lastIndex) {
                indices.add(i - p.lastIndex + 1)
                j = pi[j]
            } else {
                j++
            }
        }
    }
    return indices
}

private fun getPi(pattern: String): IntArray {
    val pi = IntArray(pattern.length)
    var j = 0
    for (i in 1 until pattern.length) {
        while (j > 0 && pattern[i] != pattern[j]) {
            j = pi[j - 1]
        }
        if (pattern[i] == pattern[j]) {
            pi[i] = ++j
        }
    }
    return pi
}
