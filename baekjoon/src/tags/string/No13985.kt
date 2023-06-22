package tags.string

/**
 * https://www.acmicpc.net/problem/13985
 */
fun main() {
    val s = readln().split(" ")
    val a = s[0].toInt()
    val b = s[2].toInt()
    val c = s[4].toInt()
    if (a + b == c) {
        println("YES")
    } else {
        println("NO")
    }
}
