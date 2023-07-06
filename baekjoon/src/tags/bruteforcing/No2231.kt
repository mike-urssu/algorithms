package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2231
 */
fun main() {
    val n = readln().toInt()
    for (i in 1..1000000) {
        if (n == getDecomposition(i)) {
            println(i)
            return
        }
    }
    println(0)
}

private fun getDecomposition(number: Int) =
    number + number.toString().sumOf { it.digitToInt() }
