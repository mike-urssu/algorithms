package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/14626
 */
fun main() {
    val isbn = readln().toCharArray()
    val m = isbn.last().digitToInt()
    val index = isbn.indexOf('*')

    (0..9).forEach { i ->
        isbn[index] = '0' + i
        val sum = (0 until 12).sumOf { j ->
            if (j % 2 == 0) {
                isbn[j].digitToInt()
            } else {
                isbn[j].digitToInt() * 3
            }
        }

        if (m == (10 - sum % 10) % 10) {
            println(i)
            return
        }
    }
}
