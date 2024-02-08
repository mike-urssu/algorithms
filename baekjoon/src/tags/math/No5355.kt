package tags.math

/**
 * https://www.acmicpc.net/problem/5355
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val input = readln().split(" ")
        println(String.format("%.2f", calculate(input[0].toDouble(), input.drop(1).map { it[0] })))
    }
}

private fun calculate(n: Double, commands: List<Char>): Double {
    var result = n
    commands.forEach { c ->
        when (c) {
            '@' -> result *= 3
            '%' -> result += 5
            '#' -> result -= 7
        }
    }
    return result
}
