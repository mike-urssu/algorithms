package tags.math

/**
 * https://www.acmicpc.net/problem/2985
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    if (a + b == c) {
        println("$a+$b=$c")
    } else if (a - b == c) {
        println("$a-$b=$c")
    } else if (a * b == c) {
        println("$a*$b=$c")
    } else if (a / b == c) {
        println("$a/$b=$c")
    } else if (a == b + c) {
        println("$a=$b+$c")
    } else if (a == b - c) {
        println("$a=$b-$c")
    } else if (a == b * c) {
        println("$a=$b*$c")
    } else {
        println("$a=$b/$c")
    }
}
