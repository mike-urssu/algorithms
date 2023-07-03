package tags.string

/**
 * https://www.acmicpc.net/problem/2671
 */
fun main() {
    val s = readln()
    if (s.matches(Regex("(100+1+|01)+"))) {
        println("SUBMARINE")
    } else {
        println("NOISE")
    }
}
