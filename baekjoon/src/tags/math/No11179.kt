package tags.math

/**
 * https://www.acmicpc.net/problem/11179
 */
fun main() {
    val n = readln().toInt()
    val binary = Integer.toBinaryString(n).reversed()
    val toInt = binary.indices.sumOf { i -> binary[i].digitToInt().shl(binary.lastIndex - i) }
    println(toInt)
}
