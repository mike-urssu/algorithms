package tags.implementation

/**
 * https://www.acmicpc.net/problem/1392
 */
fun main() {
    val (n, q) = readln().split(" ").map { it.toInt() }
    val numbers = IntArray(n) { readln().toInt() }

    val notes = mutableListOf<Int>()
    numbers.forEachIndexed { i, v ->
        repeat(v) {
            notes.add(i + 1)
        }
    }
    repeat(q) {
        val s = readln().toInt()
        println(notes[s])
    }
}
