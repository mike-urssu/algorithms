package tags.math

/**
 * https://www.acmicpc.net/problem/3460
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val binary = Integer.toBinaryString(n).reversed()
        println(binary.indices.filter { binary[it] == '1' }.joinToString(" "))
    }
}
