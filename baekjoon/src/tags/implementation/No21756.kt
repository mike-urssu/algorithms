package tags.implementation

/**
 * https://www.acmicpc.net/problem/21756
 */
fun main() {
    val n = readln().toInt()
    if (n == 1) {
        println(1)
    } else {
        val numbers = IntArray(n + 1) { it }
        while (numbers[2] != 0) {
            (1..n step 2).forEach { i -> numbers[i] = 0 }
            (1..n).forEach { i ->
                if (numbers[i] != 0) {
                    val index = (1..n).first { numbers[it] == 0 }
                    numbers[index] = numbers[i]
                    numbers[i] = 0
                }
            }
        }
        println(numbers[1])
    }
}
