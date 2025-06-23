package tags.implementation

/**
 * https://www.acmicpc.net/problem/12756
 */
fun main() {
    var (a1, l1) = readln().split(" ").map { it.toInt() }
    var (a2, l2) = readln().split(" ").map { it.toInt() }

    while (l1 > 0 && l2 > 0) {
        l1 -= a2
        l2 -= a1
    }

    if (l1 <= 0 && l2 <= 0) {
        println("DRAW")
    } else if (l2 <= 0) {
        println("PLAYER A")
    } else {
        println("PLAYER B")
    }
}
