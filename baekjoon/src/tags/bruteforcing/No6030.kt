package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/6030
 */
fun main() {
    val (p, q) = readln().split(" ").map { it.toInt() }
    val factorsOfP = getFactors(p)
    val factorsOfQ = getFactors(q)
    for (factorOfP in factorsOfP) {
        for (factorOfQ in factorsOfQ) {
            println("$factorOfP $factorOfQ")
        }
    }
}

private fun getFactors(number: Int) =
    (1..number).filter { number % it == 0 }
