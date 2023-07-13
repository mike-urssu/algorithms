package tags.sorting

/**
 * https://www.acmicpc.net/problem/1026
 */
fun main() {
    val n = readln().toInt()
    val arrayA = readln().split(" ").map { it.toInt() }.toIntArray()
    val arrayB = readln().split(" ").map { it.toInt() }.toIntArray()
    println(findS(n, arrayA, arrayB))
}

private fun findS(n: Int, arrayA: IntArray, arrayB: IntArray): Int {
    val rearrangedArrayA = rearrangeArrayA(n, arrayA, arrayB)
    return (0 until n).sumOf { i -> rearrangedArrayA[i] * arrayB[i] }
}

private fun rearrangeArrayA(n: Int, arrayA: IntArray, arrayB: IntArray): IntArray {
    val sortedArray = arrayA.sortedArrayDescending()
    val orders = getOrders(n, arrayB)
    return IntArray(n) { i -> sortedArray[orders[i]] }
}

private fun getOrders(n: Int, array: IntArray): IntArray {
    val sortedArray = array.sortedArray()
    val isVisited = BooleanArray(n)
    val orders = IntArray(n)
    for (i in orders.indices) {
        for (j in 0 until n) {
            if (!isVisited[j] && array[i] == sortedArray[j]) {
                orders[i] = j
                isVisited[j] = true
                break
            }
        }
    }
    return orders
}
