package tags.implementation

/**
 * https://www.acmicpc.net/problem/10801
 */
fun main() {
    val a = readln().split(" ").map { it.toInt() }.toIntArray()
    val b = readln().split(" ").map { it.toInt() }.toIntArray()

    val winA = (0 until 10).count { i -> a[i] > b[i] }
    val tie = (0 until 10).count { i -> a[i] == b[i] }
    val winB = 10 - winA - tie

    if (winA > winB) {
        println("A")
    } else if (winA == winB) {
        println("D")
    } else {
        println("B")
    }
}
