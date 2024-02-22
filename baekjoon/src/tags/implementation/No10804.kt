package tags.implementation

/**
 * https://www.acmicpc.net/problem/10804
 */
fun main() {
    val numbers = IntArray(21) { it }
    repeat(10) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        swap(numbers, a, b)
    }
    println(numbers.drop(1).joinToString(" "))
}

private fun swap(numbers: IntArray, a: Int, b: Int) {
    repeat((b - a + 1) / 2) { i ->
        val temp = numbers[a + i]
        numbers[a + i] = numbers[b - i]
        numbers[b - i] = temp
    }
}
