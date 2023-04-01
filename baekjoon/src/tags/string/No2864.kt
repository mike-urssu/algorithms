package tags.string

/**
 * https://www.acmicpc.net/problem/2864
 */
fun main() {
    val (a, b) = readln().split(" ")
    val min = a.replace("6", "5").toInt() + b.replace("6", "5").toInt()
    val max = a.replace("5", "6").toInt() + b.replace("5", "6").toInt()
    println("$min $max")
}
