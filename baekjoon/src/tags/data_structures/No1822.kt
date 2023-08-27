package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1822
 */
fun main() {
    readln()
    val a = readln().split(" ").map { it.toInt() }.toSortedSet()
    val b = readln().split(" ").map { it.toInt() }.toSet()

    a.removeAll(b)

    if (a.isEmpty()) {
        println(0)
    } else {
        println(a.size)
        println(a.joinToString(" "))
    }
}
