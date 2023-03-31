package tags.string

/**
 * https://www.acmicpc.net/problem/1769
 */
fun main() {
    var x = readln()
    var cycle = 0
    val isTriple: Boolean

    while (true) {
        if (x.length == 1) {
            isTriple = x.toInt() % 3 == 0
            break
        }
        x = x.sumOf { it.digitToInt() }.toString()
        cycle++
    }

    println(cycle)
    if (isTriple) {
        println("YES")
    } else {
        println("NO")
    }
}
