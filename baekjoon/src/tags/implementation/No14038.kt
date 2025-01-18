package tags.implementation

/**
 * https://www.acmicpc.net/problem/14038
 */
fun main() {
    var wins = 0
    repeat(6) {
        if (readln() == "W") {
            wins++
        }
    }
    val group = if (wins >= 5) {
        1
    } else if (wins >= 3) {
        2
    } else if (wins >= 1) {
        3
    } else {
        -1
    }
    println(group)
}
