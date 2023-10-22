package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/10973
 */
fun main() {
    val n = readln().toInt()
    val sequence = readln().split(" ").map { it.toInt() }.toIntArray()

    if (hasPreviousSequence(n, sequence)) {
        println(getPreviousSequence(n, sequence).joinToString(" "))
    } else {
        println(-1)
    }
}

private fun hasPreviousSequence(n: Int, sequence: IntArray) =
    (0 until n - 1).any { i -> sequence[i] > sequence[i + 1] }

private fun getPreviousSequence(n: Int, sequence: IntArray): IntArray {
    val previousSequence = sequence.copyOf()
    val index = (n - 2 downTo 0).first { i -> sequence[i] > sequence[i + 1] }
    val swapIndex = findMinIndex(n, previousSequence, index)
    swap(previousSequence, index, swapIndex)
    previousSequence.sortDescending(index + 1, n)
    return previousSequence
}

private fun findMinIndex(n: Int, sequence: IntArray, index: Int): Int {
    var swapIndex = -1
    var max = 0
    for (i in index + 1 until n) {
        if (sequence[index] > sequence[i] && max < sequence[i]) {
            max = sequence[i]
            swapIndex = i
        }
    }
    return swapIndex
}

private fun swap(sequence: IntArray, x: Int, y: Int) {
    val temp = sequence[x]
    sequence[x] = sequence[y]
    sequence[y] = temp
}
