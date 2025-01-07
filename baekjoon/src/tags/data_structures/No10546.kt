package tags.data_structures

/**
 * https://www.acmicpc.net/problem/10546
 */
fun main() {
    val names = mutableSetOf<String>()
    val n = readln().toInt()
    repeat(n * 2 - 1) {
        val name = readln()
        if (names.contains(name)) {
            names.remove(name)
        } else {
            names.add(name)
        }
    }
    println(names.first())
}
