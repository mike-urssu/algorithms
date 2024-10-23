package tags.implementation

/**
 * https://www.acmicpc.net/problem/28431
 */
fun main() {
    val socks = IntArray(10)
    repeat(5) {
        val n = readln().toInt()
        socks[n]++
    }
    val sock = (0 until 10).first { socks[it] % 2 == 1 }
    println(sock)
}
