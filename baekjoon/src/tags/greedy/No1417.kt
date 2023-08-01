package tags.greedy

/**
 * https://www.acmicpc.net/problem/1417
 */
fun main() {
    val n = readln().toInt()
    val votes = IntArray(n) { readln().toInt() }

    val v = votes[0]
    while (true) {
        val index = getIndex(votes)
        if (index == 0) {
            break
        }
        votes[0]++
        votes[index]--
    }
    println(votes[0] - v)
}

private fun getIndex(votes: IntArray): Int {
    var max = votes[0]
    var index = 0
    for (i in votes.indices) {
        if (votes[i] >= max) {
            max = votes[i]
            index = i
        }
    }
    return index
}
