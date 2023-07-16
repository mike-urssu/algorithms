package tags.sorting

/**
 * https://www.acmicpc.net/problem/1253
 */
fun main() {
    readln()
    val numbers = readln().split(" ").map { it.toInt() }.sorted()
    val count = numbers.indices.count { i -> isGood(numbers, i) }
    println(count)
}

private fun isGood(numbers: List<Int>, index: Int): Boolean {
    var low = 0
    var high = numbers.lastIndex
    while (low < high) {
        if (low == index) {
            low++
        } else if (high == index) {
            high--
        } else {
            val sum = numbers[low] + numbers[high]
            if (numbers[index] > sum) {
                low++
            } else if (numbers[index] == sum) {
                return true
            } else {
                high--
            }
        }
    }
    return false
}
