package tags.string

/**
 * acmicpc.net/problem/1259
 */
fun main() {
    while (true) {
        val number = readln()
        if (number == "0") {
            break
        }
        if (number == number.reversed()) {
            println("yes")
        } else {
            println("no")
        }
    }
}
