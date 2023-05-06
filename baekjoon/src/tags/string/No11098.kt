package tags.string

/**
 * https://www.acmicpc.net/problem/11098
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val p = readln().toInt()
        val prices = mutableListOf<Int>()
        val names = mutableListOf<String>()
        repeat(p) {
            val (c, name) = readln().split(" ")
            prices.add(c.toInt())
            names.add(name)
        }
        println(names[prices.indexOf(prices.max())])
    }
}
