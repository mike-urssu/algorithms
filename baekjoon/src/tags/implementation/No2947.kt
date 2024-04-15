package tags.implementation

/**
 * https://www.acmicpc.net/problem/2947
 */
private val orders = intArrayOf(1, 2, 3, 4, 5)

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    while (true) {
        if (numbers.contentEquals(orders)) {
            return
        }

        if (numbers[0] > numbers[1]) {
            swap(numbers, 0, 1)
            println(numbers.joinToString(" "))
        }
        if (numbers[1] > numbers[2]) {
            swap(numbers, 1, 2)
            println(numbers.joinToString(" "))
        }
        if (numbers[2] > numbers[3]) {
            swap(numbers, 2, 3)
            println(numbers.joinToString(" "))
        }
        if (numbers[3] > numbers[4]) {
            swap(numbers, 3, 4)
            println(numbers.joinToString(" "))
        }
    }
}

private fun swap(numbers: IntArray, i: Int, j: Int) {
    val temp = numbers[i]
    numbers[i] = numbers[j]
    numbers[j] = temp
}
