package tags.implementation

/**
 * https://www.acmicpc.net/problem/1138
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getOrders(n, numbers).joinToString(" "))
}

private fun getOrders(n: Int, numbers: IntArray): IntArray {
    val orders = IntArray(n)
    for (i in 0 until n) {
        var zeros = 0
        for (j in 0 until n) {
            if (zeros == numbers[i]) {
                val index = (j until n).first { k -> orders[k] == 0 }
                orders[index] = i + 1
                break
            }
            if (orders[j] == 0) {
                zeros++
            }
        }
    }
    return orders
}
