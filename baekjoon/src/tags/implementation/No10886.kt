package tags.implementation

/**
 * https://www.acmicpc.net/problem/10886
 */
fun main() {
    val n = readln().toInt()
    val count = (1..n).count { readln().toInt() == 1 }
    if ((n + 1) / 2 <= count) {
        println("Junhee is cute!")
    } else {
        println("Junhee is not cute!")
    }
}
