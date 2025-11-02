package tags.implementation

/**
 * https://www.acmicpc.net/problem/20673
 */
fun main() {
    val p = readln().toInt()
    val q = readln().toInt()
    val color = if (p <= 50 && q <= 10) {
        "White"
    } else if (q > 30) {
        "Red"
    } else {
        "Yellow"
    }
    println(color)
}
