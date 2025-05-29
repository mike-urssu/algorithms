package tags.string

/**
 * https://www.acmicpc.net/problem/4447
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val name = readln()
        val countG = name.count { it == 'g' || it == 'G' }
        val countB = name.count { it == 'b' || it == 'B' }
        if (countB < countG) {
            println("$name is GOOD")
        } else if (countB == countG) {
            println("$name is NEUTRAL")
        } else {
            println("$name is A BADDY")
        }
    }
}
