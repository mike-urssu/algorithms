package tags.sorting

/**
 * https://www.acmicpc.net/problem/1920
 */
fun main() {
    readln()
    val givenNumbers = readln().split(" ").map { it.toInt() }.sorted()
    readln()
    val numbers = readln().split(" ").map { it.toInt() }
    numbers.forEach { number ->
        val index = givenNumbers.binarySearch(number)
        if (index >= 0) {
            println(1)
        } else {
            println(0)
        }
    }
}
