package tags.string

/**
 * https://www.acmicpc.net/problem/10798
 */
fun main() {
    val words = Array(5) { readln() }
    val s = StringBuilder()
    val size = words.maxOf { it.length }
    for (i in 0 until size) {
        for (word in words) {
            if (i < word.length) {
                s.append(word[i])
            }
        }
    }
    println(s.toString())
}
