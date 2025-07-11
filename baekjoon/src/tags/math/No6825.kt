package tags.math

/**
 * https://www.acmicpc.net/problem/6825
 */
fun main() {
    val weight = readln().toDouble()
    val height = readln().toDouble()
    val bmi = weight / (height * height)
    if (bmi > 25) {
        println("Overweight")
    } else if (bmi >= 18.5) {
        println("Normal weight")
    } else {
        println("Underweight")
    }
}
