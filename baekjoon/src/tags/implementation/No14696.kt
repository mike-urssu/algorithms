package tags.implementation

/**
 * https://www.acmicpc.net/problem/14696
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val a = readln().split(" ").map { it.toInt() }.drop(1).groupingBy { it }.eachCount()
        val b = readln().split(" ").map { it.toInt() }.drop(1).groupingBy { it }.eachCount()

        var c = (a[4] ?: 0).compareTo(b[4] ?: 0)
        if (c == 0) {
            c = (a[3] ?: 0).compareTo(b[3] ?: 0)
        }
        if (c == 0) {
            c = (a[2] ?: 0).compareTo(b[2] ?: 0)
        }
        if (c == 0) {
            c = (a[1] ?: 0).compareTo(b[1] ?: 0)
        }

        val winner = if (c == 1) {
            "A"
        } else if (c == -1) {
            "B"
        } else {
            "D"
        }
        println(winner)
    }
}
