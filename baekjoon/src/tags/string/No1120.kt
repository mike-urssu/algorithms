package tags.string

/**
 * https://www.acmicpc.net/problem/1120
 */
fun main() {
    val (a, b) = readln().split(" ")
    val count = (0..b.length - a.length)
        .minOf { diff(a, b.substring(it, it + a.length)) }
    println(count)
}

private fun diff(s1: String, s2: String) = s1.indices.count { s1[it] != s2[it] }
