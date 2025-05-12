package tags.math

/**
 * https://www.acmicpc.net/problem/25591
 */
fun main() {
    val (n1, n2) = readln().split(" ").map { it.toInt() }
    val a = 100 - n1
    val b = 100 - n2
    val c = 100 - (a + b)
    val d = a * b
    val q = d / 100
    val r = d % 100

    println("$a $b $c $d $q $r")
    println("${c + q} $r")
}
