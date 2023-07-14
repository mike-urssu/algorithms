package tags.string

/**
 * https://www.acmicpc.net/problem/1235
 */
fun main() {
    val n = readln().toInt()
    val numbers = Array(n) { readln() }
    println(findK(n, numbers))
}

private fun findK(n: Int, numbers: Array<String>): Int {
    val length = numbers[0].length
    for (i in length - 1 downTo 0) {
        val distinctCounts = numbers.map { it.substring(i) }.distinct().count()
        if (distinctCounts == n) {
            return length - i
        }
    }
    return length
}
