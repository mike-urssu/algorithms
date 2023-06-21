package tags.dynamic

/**
 * https://www.acmicpc.net/problem/2775
 */
fun main() {
    val prefixSum = getPrefixSum()
    val t = readln().toInt()
    repeat(t) {
        val k = readln().toInt()
        val n = readln().toInt()
        println(prefixSum[k][n])
    }
}

private fun getPrefixSum(): List<IntArray> {
    val prefixSum = mutableListOf<IntArray>()
    val people = (0..14).map { it }.toIntArray()
    prefixSum.add(people)
    repeat(14) {
        val last = prefixSum.last().runningFold(0, Int::plus).drop(1).toIntArray()
        prefixSum.add(last)
    }
    return prefixSum
}
