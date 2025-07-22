package tags.string

/**
 * https://www.acmicpc.net/problem/12871
 */
fun main() {
    val s = readln()
    val t = readln()
    if (reduce(s) == reduce(t)) {
        println(1)
    } else {
        println(0)
    }
}

private fun reduce(s: String): String {
    for (i in 1..s.length) {
        if (s.length % i == 0) {
            val distinct = s.chunked(i).distinct()
            if (distinct.size == 1) {
                return distinct[0]
            }
        }
    }
    return s
}
