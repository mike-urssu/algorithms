package tags.implementation

/**
 * https://www.acmicpc.net/problem/10768
 */
fun main() {
    val n1 = readln().toInt()
    val n2 = readln().toInt()

    if (n1 == 1) {
        println("Before")
    } else if (n1 == 2) {
        if (n2 < 18) {
            println("Before")
        } else if (n2 == 18) {
            println("Special")
        } else {
            println("After")
        }
    } else {
        println("After")
    }
}
