package tags.lis

/**
 * https://www.acmicpc.net/problem/18353
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    println(n - lis(n, numbers))
}

private fun lis(n: Int, numbers: List<Int>): Int {
    val lis = mutableListOf<Int>()
    (0 until n).forEach { i ->
        val index = binarySearch(lis, numbers[i])
        if (index == lis.size) {
            lis.add(numbers[i])
        } else {
            lis[index] = numbers[i]
        }
    }
    return lis.size
}

private fun binarySearch(lis: List<Int>, v: Int): Int {
    var low = -1
    var high = lis.size
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (lis[mid] > v) {
            low = mid
        } else {
            high = mid
        }
    }
    return high
}
