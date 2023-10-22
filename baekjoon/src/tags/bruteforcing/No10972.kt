package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/10972
 */
fun main() {
    val n = readln().toInt()
    val sequence = readln().split(" ").map { it.toInt() }.toIntArray()

    if (hasNextSequence(n, sequence)) {
        println(getNextSequence(n, sequence).joinToString(" "))
    } else {
        println(-1)
    }
}

private fun hasNextSequence(n: Int, sequence: IntArray) =
    (0 until n - 1).any { i -> sequence[i] < sequence[i + 1] }

private fun getNextSequence(n: Int, sequence: IntArray): IntArray {
    val nextSequence = sequence.copyOf()
    val index = (n - 1 downTo 1).first { i -> sequence[i - 1] < sequence[i] } - 1
    swap(n, nextSequence, index)
    nextSequence.sort(index + 1)
    return nextSequence
}

private fun swap(n: Int, sequence: IntArray, index: Int) {
    for (i in n - 1 downTo index + 1) {
        if (sequence[index] < sequence[i]) {
            val temp = sequence[index]
            sequence[index] = sequence[i]
            sequence[i] = temp
            return
        }
    }
}
