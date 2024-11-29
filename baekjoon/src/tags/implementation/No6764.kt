package tags.implementation

/**
 * https://www.acmicpc.net/problem/6764
 */
fun main() {
    val numbers = Array(4) { readln().toInt() }
    val output = if (numbers[0] < numbers[1] && numbers[1] < numbers[2] && numbers[2] < numbers[3]) {
        "Fish Rising"
    } else if (numbers[0] > numbers[1] && numbers[1] > numbers[2] && numbers[2] > numbers[3]) {
        "Fish Diving"
    } else if (numbers[0] == numbers[1] && numbers[1] == numbers[2] && numbers[2] == numbers[3]) {
        "Fish At Constant Depth"
    } else {
        "No Fish"
    }
    println(output)
}
