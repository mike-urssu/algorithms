package tags.lis

/**
 * https://www.acmicpc.net/problem/11568
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }

    val lis = mutableListOf<Int>().apply { this.add(numbers[0]) }
    (1 until n).forEach { i ->
        val index = binarySearch(lis, numbers[i])
        if (index == lis.size) {
            lis.add(numbers[i])
        } else {
            lis[index] = numbers[i]
        }
    }

    println(lis.size)
}

private fun binarySearch(lis: List<Int>, number: Int): Int {
    var low = -1
    var high = lis.size
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (number <= lis[mid]) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
