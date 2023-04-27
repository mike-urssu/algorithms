package tags.string

/**
 * https://www.acmicpc.net/problem/25206
 */
fun main() {
    val grades = arrayOf("A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F")
    val scores = arrayOf(4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0)

    var sum = 0.0
    var credits = 0.0
    repeat(20) {
        val s = readln().split(" ")
        if (s[2] != "P") {
            credits += s[1].toDouble()
            sum += s[1].toDouble() * scores[grades.indexOf(s[2])]
        }
    }
    println(sum / credits)
}
