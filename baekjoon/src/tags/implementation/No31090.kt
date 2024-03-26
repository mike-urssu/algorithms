package tags.implementation

/**
 * https://www.acmicpc.net/problem/31090
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        if ((n + 1) % (n % 100) == 0) {
            println("Good")
        } else {
            println("Bye")
        }
    }
}
