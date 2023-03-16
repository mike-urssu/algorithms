package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/2635
 */
fun main() {
    val n = readln().toInt()

    var answer = mutableListOf<Int>()
    for (i in 1..n) {
        val numbers = mutableListOf<Int>()
        numbers.add(n)
        numbers.add(i)

        while (true) {
            val number = numbers[numbers.lastIndex - 1] - numbers[numbers.lastIndex]
            if (number < 0) {
                break
            }
            numbers.add(number)
        }

        if (answer.size < numbers.size) {
            answer = numbers
        }
    }

    println(answer.size)
    println(answer.joinToString(" "))
}
