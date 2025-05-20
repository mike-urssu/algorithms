package tags.string

/**
 * https://www.acmicpc.net/problem/32929
 */
fun main() {
    val x = readln().toInt()
    println("UOS"[(x - 1) % 3])
}
