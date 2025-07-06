package tags.math

/**
 * https://www.acmicpc.net/problem/15921
 */
fun main() {
    val n = readln().toInt()
    if (n == 0) {
        println("divide by zero")
        return
    }
    val p = readln().split(" ").map { it.toDouble() }.toDoubleArray()
    val average = p.average()
    val expectations = p.distinct().sumOf { it * p.count { o -> it == o } } / n
    println(String.format("%.2f", average / expectations))
}
