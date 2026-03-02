package tags.data_structures

/**
 * https://www.acmicpc.net/problem/32978
 */
fun main() {
    readln()
    val set1 = readln().split(" ").toMutableSet()
    val set2 = readln().split(" ").toSet()
    set1.removeAll(set2)
    println(set1.first())
}
