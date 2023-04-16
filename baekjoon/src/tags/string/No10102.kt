package tags.string

/**
 * https://www.acmicpc.net/problem/10102
 */
fun main() {
    readln()
    val group = readln().groupingBy { it }.eachCount()
    val a = group['A'] ?: 0
    val b = group['B'] ?: 0
    if (a > b) {
        println("A")
    } else if (a == b) {
        println("Tie")
    } else {
        println("B")
    }
}
