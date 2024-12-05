package tags.greedy

/**
 * https://www.acmicpc.net/problem/9009
 */
private val fibonacci = fibonacci()

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        println(composition(n).joinToString(" "))
    }
}

private fun fibonacci(): List<Int> {
    val fibonacci = mutableListOf<Int>()
    fibonacci.add(1)
    fibonacci.add(1)
    var index = 2
    while (true) {
        val sum = fibonacci[index - 2] + fibonacci[index - 1]
        if (sum > 1_000_000_000) {
            break
        }
        fibonacci.add(sum)
        index++
    }
    return fibonacci
}

private fun composition(n: Int): List<Int> {
    val composition = mutableListOf<Int>()
    var index = fibonacci.lastIndex
    var sum = n
    while (sum > 0) {
        val f = fibonacci[index--]
        if (f <= sum) {
            composition.add(f)
            sum -= f
        }
    }
    return composition.reversed()
}
