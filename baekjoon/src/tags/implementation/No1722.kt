package tags.implementation

/**
 * https://www.acmicpc.net/problem/1722
 */
fun main() {
    val n = readln().toInt()
    val input = readln().split(" ").map { it.toLong() }
    if (input[0] == 1L) {
        println(getSequence(n, input[1]).joinToString(" "))
    } else {
        println(getOrder(n, input.map { it.toInt() }.drop(1)))
    }
}

private fun getSequence(n: Int, k: Long): MutableList<Int> {
    val isVisited = BooleanArray(n + 1)
    isVisited[0] = true
    var order = k - 1
    var m = n - 1
    var factorial = factorial(m)

    val sequence = mutableListOf<Int>()
    while (order > 0L) {
        val index = (order / factorial).toInt()
        val v = (1..n).filter { !isVisited[it] }[index]
        sequence.add(v)
        isVisited[v] = true

        order -= index * factorial
        factorial /= m--
    }
    sequence.addAll((1..n).filter { !isVisited[it] })
    return sequence
}

private fun getOrder(n: Int, numbers: List<Int>): Long {
    val isVisited = BooleanArray(n + 1)
    isVisited[0] = true
    var m = n - 1
    var factorial = factorial(m)

    var order = 1L
    (0 until n - 1).forEach { i ->
        val v = numbers[i]
        isVisited[v] = true

        val count = (1..v).count { !isVisited[it] }
        order += factorial * count
        factorial /= m--
    }
    return order
}

private fun factorial(n: Int): Long {
    var factorial = 1L
    (1..n).forEach { factorial *= it }
    return factorial
}
