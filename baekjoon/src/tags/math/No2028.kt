package tags.math

/**
 * https://www.acmicpc.net/problem/2028
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val m = n * n
        if (m.toString().endsWith(n.toString())) {
            println("YES")
        } else {
            println("NO")
        }
    }
}
