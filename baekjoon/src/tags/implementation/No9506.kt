package tags.implementation

/**
 * https://www.acmicpc.net/problem/9506
 */
fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == -1) {
            break
        }
        val factors = getFactors(n)
        if (n == factors.sum()) {
            println("$n = ${factors.joinToString(" + ")}")
        } else {
            println("$n is NOT perfect.")
        }
    }
}

private fun getFactors(n: Int) =
    (1 until n).filter { i -> n % i == 0 }
