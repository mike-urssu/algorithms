package tags.data_structures

/**
 * https://www.acmicpc.net/problem/10815
 */
fun main() {
    readln()
    val cards = readln().split(" ").map { it.toInt() }.toIntArray().sortedArray()
    readln()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    numbers.forEach { number ->
        if (cards.binarySearch(number) >= 0) {
            print("1 ")
        } else {
            print("0 ")
        }
    }
}
