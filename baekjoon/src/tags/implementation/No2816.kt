package tags.implementation

/**
 * https://www.acmicpc.net/problem/2816
 */
fun main() {
    val n = readln().toInt()
    val channels = Array(n) { readln() }
    val kbs1 = channels.indexOf("KBS1")
    val kbs2 = channels.indexOf("KBS2")

    val buttons = StringBuilder()
    buttons.append("1".repeat(kbs1))
    buttons.append("4".repeat(kbs1))
    if (kbs1 < kbs2) {
        buttons.append("1".repeat(kbs2))
        buttons.append("4".repeat(kbs2 - 1))
    } else {
        buttons.append("1".repeat(kbs2 + 1))
        buttons.append("4".repeat(kbs2))
    }
    println(buttons)
}
