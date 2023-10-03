package tags.binary_search

/**
 * https://www.acmicpc.net/problem/4158
 */
fun main() {
    while (true) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) {
            break
        }

        val cd1 = IntArray(n) { readln().toInt() }
        val cd2 = IntArray(n) { readln().toInt() }

        cd1.binarySearch(1)

        println(cd1.count { binarySearch(cd2, it) })
    }
}

private fun binarySearch(numbers: IntArray, n: Int): Boolean {
    var low = -1
    var high = numbers.size

    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (numbers[mid] < n) {
            low = mid
        } else if (numbers[mid] == n) {
            return true
        } else {
            high = mid
        }
    }

    return false
}
