package tags.lis

/**
 * https://www.acmicpc.net/problem/13711
 */
fun main() {
    val n = readln().toInt()
    val arrayA = readln().split(" ").map { it.toInt() }.toIntArray()
    val arrayB = readln().split(" ").map { it.toInt() }.toIntArray()

    val orders = getOrders(n, arrayA)
    val sequence = arrayB.map { orders[it] }.toIntArray()
    println(lis(sequence))
}

private fun getOrders(n: Int, array: IntArray): IntArray {
    val orders = IntArray(n + 1)
    array.forEachIndexed { i, num ->
        orders[num] = i + 1
    }
    return orders
}

private fun lis(sequence: IntArray): Int {
    val lis = mutableListOf<Int>()
    lis.add(sequence[0])
    for (i in 1 until sequence.size) {
        val index = getLowerBound(lis, sequence[i])
        if (index == lis.size) {
            lis.add(sequence[i])
        } else {
            lis[index] = sequence[i]
        }
    }
    return lis.size
}

private fun getLowerBound(lis: List<Int>, n: Int): Int {
    var low = -1
    var high = lis.size
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (lis[mid] < n) {
            low = mid
        } else {
            high = mid
        }
    }
    return high
}
