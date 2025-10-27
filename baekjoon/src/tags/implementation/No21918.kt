package tags.implementation

/**
 * https://www.acmicpc.net/problem/21918
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val lights = IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        when (a) {
            1 -> command1(lights, b, c)
            2 -> command2(lights, b, c)
            3 -> command3(lights, b, c)
            4 -> command4(lights, b, c)
        }
    }
    println(lights.drop(1).joinToString(" "))
}

private fun command1(lights: IntArray, i: Int, x: Int) {
    lights[i] = x
}

private fun command2(lights: IntArray, l: Int, r: Int) {
    (l..r).forEach { lights[it] = (lights[it] + 1) % 2 }
}

private fun command3(lights: IntArray, l: Int, r: Int) {
    (l..r).forEach { lights[it] = 0 }
}

private fun command4(lights: IntArray, l: Int, r: Int) {
    (l..r).forEach { lights[it] = 1 }
}
