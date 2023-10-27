package tags.math

/**
 * https://www.acmicpc.net/problem/11005
 */
fun main() {
    val (n, b) = readln().split(" ").map { it.toInt() }
    println(getBNary(n, b))
}

private fun getBNary(n: Int, b: Int): String {
    val bNary = StringBuilder()

    var decimal = n
    while (decimal >= b) {
        bNary.append(getNary(decimal % b))
        decimal /= b
    }
    bNary.append(getNary(decimal))

    return bNary.reversed().toString()
}

private fun getNary(n: Int) =
    if (n in 0..9) {
        n + '0'.code
    } else {
        n - 10 + 'A'.code
    }.toChar()
