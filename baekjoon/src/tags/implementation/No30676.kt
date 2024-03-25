package tags.implementation

/**
 * https://www.acmicpc.net/problem/30676
 */
fun main() {
    val color = when (readln().toInt()) {
        in (620 .. 780) -> "Red"
        in (590 until 620) -> "Orange"
        in (570 until 590) -> "Yellow"
        in (495 until 570) -> "Green"
        in (450 until 495) -> "Blue"
        in (425 until 450) -> "Indigo"
        else -> "Violet"
    }
    println(color)
}
