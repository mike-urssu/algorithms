package tags.string

/**
 * https://www.acmicpc.net/problem/12933
 */
fun main() {
    val s = readln()

    val ducks = IntArray(s.length)
    s.forEach { c ->
        val index = when (c) {
            'q' -> {
                var index = ducks.indexOf(5)
                if (index == -1) {
                    index = ducks.indexOf(0)
                }
                index
            }

            'u' -> ducks.indexOf(1)
            'a' -> ducks.indexOf(2)
            'c' -> ducks.indexOf(3)
            else -> ducks.indexOf(4)
        }

        if (index == -1) {
            println(-1)
            return
        }

        ducks[index] = if (ducks[index] == 4) {
            5
        } else {
            (ducks[index] + 1) % 5
        }
    }

    if (ducks.any { it != 0 && it != 5 }) {
        println(-1)
        return
    }
    println(ducks.count { it == 5 })
}
