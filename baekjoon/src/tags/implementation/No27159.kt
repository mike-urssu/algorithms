package tags.implementation

/**
 * https://www.acmicpc.net/problem/27159
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    var sum = numbers[0]
    for (i in 1 until n) {
        if (numbers[i] - numbers[i - 1] != 1) {
            sum += numbers[i]
        }
    }
    println(sum)
}
