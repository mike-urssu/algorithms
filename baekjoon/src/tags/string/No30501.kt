package tags.string

/**
 * https://www.acmicpc.net/problem/30501
 */
fun main() {
    val n = readln().toInt()
    val names = Array(n) { readln() }
    val suspect = names.first { name -> "S" in name }
    println(suspect)
}
