package tags.string

/**
 * https://www.acmicpc.net/problem/1541
 */
fun main() {
    val line = readln()
    val sum = if (line.indexOf('-') == -1) {
        line.split("+").sumOf { it.toInt() }
    } else {
        val numbers = line.split("-")
            .map { l -> l.split("+").sumOf { it.toInt() } }
        -numbers.sum() + numbers.first() * 2
    }
    println(sum)
}
