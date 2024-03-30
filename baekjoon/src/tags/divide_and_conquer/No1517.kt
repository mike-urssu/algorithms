package tags.divide_and_conquer

/**
 * https://www.acmicpc.net/problem/1517
 */
private lateinit var numbers: IntArray
private lateinit var sortedNumbers: IntArray
private var swap = 0L

fun main() {
    val n = readln().toInt()
    numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    sortedNumbers = IntArray(n)

    divideAndConquer(0, n - 1)

    println(swap)
}

private fun divideAndConquer(from: Int, to: Int) {
    if (from < to) {
        val mid = (from + to) shr 1
        divideAndConquer(from, mid)
        divideAndConquer(mid + 1, to)
        merge(from, mid, to)
    }
}

private fun merge(from: Int, mid: Int, to: Int) {
    var index = from
    var i = from
    var j = mid + 1
    while (i <= mid && j <= to) {
        sortedNumbers[index++] = if (numbers[i] <= numbers[j]) {
            numbers[i++]
        } else {
            swap += mid - i + 1
            numbers[j++]
        }
    }

    while (i <= mid) {
        sortedNumbers[index++] = numbers[i++]
    }

    while (j <= to) {
        sortedNumbers[index++] = numbers[j++]
    }

    sortedNumbers.copyInto(numbers, from, from, to + 1)
}
