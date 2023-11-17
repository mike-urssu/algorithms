package tags.geometry

/**
 * https://www.acmicpc.net/problem/10101
 */
fun main() {
    val d1 = readln().toInt()
    val d2 = readln().toInt()
    val d3 = readln().toInt()

    val type = if (d1 + d2 + d3 != 180) {
        "Error"
    } else if (d1 == 60 && d2 == 60 && d3 == 60) {
        "Equilateral"
    } else if (d1 == d2 || d2 == d3 || d3 == d1) {
        "Isosceles"
    } else {
        "Scalene"
    }
    println(type)
}
