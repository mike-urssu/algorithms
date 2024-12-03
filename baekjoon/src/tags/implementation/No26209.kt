package tags.implementation

/**
 * https://www.acmicpc.net/problem/26209
 */
fun main() {
    val integers = readln().split(" ")
    if (integers.any { it == "9" }) {
        println("F")
    } else {
        println("S")
    }
}
