package tags.implementation

/**
 * https://www.acmicpc.net/problem/19944
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    when (m) {
        in 1..2 -> {
            println("NEWBIE!")
        }

        in 3..n -> {
            println("OLDBIE!")
        }

        else -> {
            println("TLE!")
        }
    }
}
