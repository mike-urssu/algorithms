package tags.implementation

/**
 * https://www.acmicpc.net/problem/1713
 */
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    if (m == 0) {
        return
    }
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    val candidates = IntArray(n) { -1 }
    val votes = IntArray(n)
    val indices = IntArray(n) { -1 }

    numbers.forEachIndexed { i, c ->
        val cIndex = candidates.indexOf(c)
        if (cIndex != -1) {
            votes[cIndex]++
        } else {
            val index = candidates.indexOf(-1)
            if (index != -1) {
                candidates[index] = c
                votes[index] = 1
                indices[index] = i
            } else {
                val min = votes.min()
                val vIndex = if (votes.count { it == min } == 1) {
                    votes.indexOf(min)
                } else {
                    val minIndex = (0 until n).filter { votes[it] == min }.minOf { indices[it] }
                    indices.indexOf(minIndex)
                }
                candidates[vIndex] = c
                votes[vIndex] = 1
                indices[vIndex] = i
            }
        }
    }

    println(candidates.filter { it != -1 }.sorted().joinToString(" "))
}
