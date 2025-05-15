package tags.math

/**
 * https://www.acmicpc.net/problem/2145
 */
fun main() {
    while (true) {
        var n = readln()
        if (n == "0") {
            break
        }
        while (n.length != 1) {
            n = n.sumOf { it.digitToInt() }.toString()
        }
        println(n)
    }
}
