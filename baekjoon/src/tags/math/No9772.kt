package tags.math

/**
 * https://www.acmicpc.net/problem/9772
 */
fun main() {
    while (true) {
        val (x, y) = readln().split(" ")
        val location = if (x == "0" || y == "0") {
            "AXIS"
        } else if (x[0] != '-') {
            if (y[0] != '-') {
                "Q1"
            } else {
                "Q4"
            }
        } else {
            if (y[0] == '-') {
                "Q3"
            } else {
                "Q2"
            }
        }
        println(location)

        if (x == "0" && y == "0") {
            break
        }
    }
}
