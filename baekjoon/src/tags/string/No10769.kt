package tags.string

/**
 * https://www.acmicpc.net/problem/10769
 */
fun main() {
    val s = readln()
    val happy = s.windowed(3).count { it == ":-)" }
    val sad = s.windowed(3).count { it == ":-(" }
    if (happy == 0 && sad == 0) {
        println("none")
    } else if (happy == sad) {
        println("unsure")
    } else if (happy > sad) {
        println("happy")
    } else {
        println("sad")
    }
}
