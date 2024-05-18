package tags.math

/**
 * https://www.acmicpc.net/problem/1350
 */
fun main() {
    readln()
    val fileSizes = readln().split(" ").map { it.toInt() }.toIntArray()
    val cluster = readln().toLong()
    val sum = fileSizes.sumOf { (it + cluster - 1) / cluster * cluster }
    println(sum)
}
