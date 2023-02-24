package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1038
 */
fun main() {
    val numbers = mutableListOf<Long>()
    for (i in 0..9) {
        put(numbers, i.toLong())
    }
    numbers.sort()

    val n = readln().toInt()
    if (n >= numbers.size) {
        println(-1)
    } else {
        println(numbers[n])
    }
}

private fun put(numbers: MutableList<Long>, number: Long) {
    numbers.add(number)
    for (i in 0 until number % 10) {
        put(numbers, number * 10 + i)
    }
}
