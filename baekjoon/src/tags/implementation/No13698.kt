package tags.implementation

/**
 * https://www.acmicpc.net/problem/13698
 */
fun main() {
    val s = readln()

    val cups = IntArray(5).apply {
        this[1] = 1
        this[4] = 2
    }
    s.forEach { c ->
        when (c) {
            'A' -> swap(cups, 1, 2)
            'B' -> swap(cups, 1, 3)
            'C' -> swap(cups, 1, 4)
            'D' -> swap(cups, 2, 3)
            'E' -> swap(cups, 2, 4)
            'F' -> swap(cups, 3, 4)
        }
    }

    println(cups.indexOf(1))
    println(cups.indexOf(2))
}

private fun swap(cups: IntArray, i: Int, j: Int) {
    val temp = cups[i]
    cups[i] = cups[j]
    cups[j] = temp
}
