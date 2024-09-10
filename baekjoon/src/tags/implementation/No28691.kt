package tags.implementation

/**
 * https://www.acmicpc.net/problem/28691
 */
fun main() {
    val letter = readln()[0]
    val name = when (letter) {
        'M' -> "MatKor"
        'W' -> "WiCys"
        'C' -> "CyKor"
        'A' -> "AlKor"
        else -> "\$clear"
    }
    println(name)
}
