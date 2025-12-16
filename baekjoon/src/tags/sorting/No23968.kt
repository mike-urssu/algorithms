package tags.sorting

/**
 * https://www.acmicpc.net/problem/23968
 */
private lateinit var numbers: IntArray

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    var count = 0
    for (last in n downTo 1) {
        for (i in 0 until last - 1) {
            if (numbers[i] > numbers[i + 1]) {
                swap(i, i + 1)
                count++

                if (count == k) {
                    val min = minOf(numbers[i], numbers[i + 1])
                    val max = maxOf(numbers[i], numbers[i + 1])
                    println("$min $max")
                    return
                }
            }
        }
    }
    if (count < k) {
        println(-1)
    } else {
        println()
    }
}

private fun swap(i: Int, j: Int) {
    val temp = numbers[i]
    numbers[i] = numbers[j]
    numbers[j] = temp
}
