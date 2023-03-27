package tags.string

/**
 * https://www.acmicpc.net/problem/1764
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val unheard = mutableSetOf<String>()
    val unseen = mutableSetOf<String>()
    repeat(n) { unheard.add(readln()) }
    repeat(m) { unseen.add(readln()) }

    val names = unheard
        .filter { unseen.contains(it) }
        .sorted()

    println(names.size)
    names.forEach { println(it) }
}
