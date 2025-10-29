package tags.string

/**
 * https://www.acmicpc.net/problem/11367
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (a, b) = readln().split(" ")
        println("$a ${parse(b.toInt())}")
    }
}

private fun parse(grade: Int): String {
    return when (grade) {
        in 97..100 -> "A+"
        in 90..96 -> "A"
        in 87..89 -> "B+"
        in 80..86 -> "B"
        in 77..79 -> "C+"
        in 70..76 -> "C"
        in 67..69 -> "D+"
        in 60..66 -> "D"
        else -> "F"
    }
}
