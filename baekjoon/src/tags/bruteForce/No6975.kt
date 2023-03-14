package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/6975
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val number = readln().toInt()
        val sum = sumDivisors(number)
        if (sum > number) {
            println("$number is an abundant number.")
        } else if (sum == number) {
            println("$number is a perfect number.")
        } else {
            println("$number is a deficient number.")
        }
        println()
    }
}

private fun sumDivisors(number: Int): Int {
    var sum = 0
    for (i in 1 until number) {
        if (number % i == 0) {
            sum += i
        }
    }
    return sum
}
