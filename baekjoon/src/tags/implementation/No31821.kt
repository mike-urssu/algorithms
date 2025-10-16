package tags.implementation

/**
 * https://www.acmicpc.net/problem/31821
 */
fun main() {
    val n = readln().toInt()
    val prices = IntArray(n) { readln().toInt() }
    val m = readln().toInt()
    val choices = IntArray(m) { readln().toInt() - 1 }
    val sum = choices.sumOf { prices[it] }
    println(sum)
}
