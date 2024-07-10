package tags.implementation

/**
 * https://www.acmicpc.net/problem/15232
 */
fun main() {
    val r = readln().toInt()
    val c = readln().toInt()
    repeat(r) {
        println("*".repeat(c))
    }
}
