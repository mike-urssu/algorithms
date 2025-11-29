package tags.divide_and_conquer

/**
 * https://www.acmicpc.net/problem/11582
 */
private lateinit var numbers: IntArray
private lateinit var sortedNumbers: IntArray
private lateinit var snapshot: IntArray

fun main() {
    val n = readln().toInt()
    numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    val k = readln().toInt()
    sortedNumbers = IntArray(n)
    snapshot = IntArray(n)

    divide(1, k, 0, n - 1)

    println(snapshot.joinToString(" "))
}

private fun divide(n: Int, k: Int, left: Int, right: Int) {
    if (left == right) {
        return
    }

    val mid = (left + right) shr 1
    divide(n * 2, k, left, mid)
    divide(n * 2, k, mid + 1, right)
    merge(left, mid, right)
    sortedNumbers.copyInto(numbers, left, left, right + 1)

    if (n == k) {
        sortedNumbers.copyInto(snapshot, left, left, right + 1)
    }
}

private fun merge(left: Int, mid: Int, right: Int) {
    var i = left
    var j = mid + 1
    var k = left

    while (i <= mid && j <= right) {
        sortedNumbers[k++] = if (numbers[i] <= numbers[j]) {
            numbers[i++]
        } else {
            numbers[j++]
        }
    }
    while (i <= mid) {
        sortedNumbers[k++] = numbers[i++]
    }
    while (j <= right) {
        sortedNumbers[k++] = numbers[j++]
    }
}
