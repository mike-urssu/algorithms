package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/6679
 */
private val values = listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')

fun main() {
    (1000..9999)
        .filter { number ->
            val n10 = sumDigits(number.toString())
            val n12 = sumDigits(twelve(number))
            val n16 = sumDigits(String.format("%x", number))
            n10 == n12 && n12 == n16
        }
        .forEach { println(it) }
}

private fun twelve(number: Int): String {
    val twelve = StringBuilder()
    var n = number
    while (n != 0) {
        twelve.append(values[n % 12])
        n /= 12
    }
    return twelve.toString().reversed()
}

private fun sumDigits(number: String) = number.sumOf { values.indexOf(it) }
