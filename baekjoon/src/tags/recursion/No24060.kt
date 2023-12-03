package tags.recursion

/**
 * https://www.acmicpc.net/problem/24060
 */
private var n = 0
private var k = 0
private lateinit var mergedArray: IntArray

private var count = 0
private var answer = -1

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    k = input[1]
    val array = readln().split(" ").map { it.toInt() }.toIntArray()

    mergedArray = IntArray(n)
    mergeSort(array, 0, n - 1)

    println(answer)
}

private fun mergeSort(array: IntArray, left: Int, right: Int) {
    if (left == right) {
        return
    }

    val mid = (left + right) shr 1
    mergeSort(array, left, mid)
    mergeSort(array, mid + 1, right)
    merge(array, left, mid, right)
}

private fun merge(array: IntArray, left: Int, mid: Int, right: Int) {
    var i = left
    var j = mid + 1
    var index = left

    while (i <= mid && j <= right) {
        mergedArray[index++] = if (array[i] < array[j]) {
            array[i++]
        } else {
            array[j++]
        }
    }

    while (i <= mid) {
        mergedArray[index++] = array[i++]
    }
    while (j <= right) {
        mergedArray[index++] = array[j++]
    }

    for (l in left..right) {
        array[l] = mergedArray[l]
        if (++count == k) {
            answer = array[l]
        }
    }
}
