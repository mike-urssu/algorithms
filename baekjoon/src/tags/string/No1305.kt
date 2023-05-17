package tags.string

/**
 * https://www.acmicpc.net/problem/1305
 */
fun main() {
    val l = readln().toInt()
    val s = readln()
    println(l - getPi(s).last())
}

private fun getPi(p: String): IntArray {
    val pi = IntArray(p.length)
    var j = 0
    for (i in 1 until p.length) {
        while (j > 0 && p[i] != p[j]) {
            j = pi[j - 1]
        }
        if (p[i] == p[j]) {
            pi[i] = ++j
        }
    }
    return pi
}
