package tags.math

/**
 * https://www.acmicpc.net/problem/30979
 */
fun main() {
    val t = readln().toInt()
    readln()
    val flavors = readln().split(" ").map { it.toInt() }
    if (t <= flavors.sum()) {
        println("Padaeng_i Happy")
    } else {
        println("Padaeng_i Cry")
    }
}
