package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1620
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val pokemonsAsArray = Array(n + 1) { "" }
    val pokemonsAsMap = mutableMapOf<String, Int>()
    repeat(n) { i ->
        val pokemon = readln()
        pokemonsAsArray[i + 1] = pokemon
        pokemonsAsMap[pokemon] = i + 1
    }
    repeat(m) {
        val input = readln()
        if (input[0].isDigit()) {
            println(pokemonsAsArray[input.toInt()])
        } else {
            println(pokemonsAsMap[input]!!)
        }
    }
}
