package tags.binary_search

/**
 * https://www.acmicpc.net/problem/1920
 */
fun main() {
    readln()
    val a = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    readln()
    val numbers = readln().split(" ").map { it.toInt() }
    numbers.forEach {
        if (isExist(it, a)) {
            println(1)
        } else {
            println(0)
        }
    }
}

private fun isExist(x: Int, a: IntArray): Boolean {
    var low = 0
    var high = a.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (a[mid] > x) {
            high = mid
        } else {
            low = mid
        }
    }
    return a[low] == x
}
