package tags.string

/**
 * https://www.acmicpc.net/problem/14425
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var count = 0
    val words = sortedSetOf<String>()
    repeat(n) { words.add(readln()) }
    repeat(m) {
        if (words.contains(readln())) {
            count++
        }
    }
    println(count)
}
