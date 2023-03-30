package tags.string

/**
 * https://www.acmicpc.net/problem/11478
 */
fun main() {
    val s = readln()
    val substrings = sortedSetOf<String>()
    for (i in s.indices) {
        for (j in i + 1..s.length) {
            substrings.add(s.substring(i, j))
        }
    }
    println(substrings.size)
}
