package tags.greedy

/**
 * https://www.acmicpc.net/problem/2138
 */
import kotlin.system.exitProcess

private var n = 0
private lateinit var before: BooleanArray
private lateinit var after: BooleanArray

fun main() {
    n = readln().toInt()
    before = readln().map { it == '1' }.toBooleanArray()
    after = readln().map { it == '1' }.toBooleanArray()

    switch(0, 0)
    println(-1)
}

private fun switch(index: Int, count: Int) {
    if (index == n) {
        if ((n - 2 until n).all { before[it] == after[it] }) {
            println(count)
            exitProcess(0)
        }
        return
    }

    if (index >= 2) {
        if (before[index - 2] != after[index - 2]) {
            return
        }
    }

    switch(index + 1, count)
    pressButton(index)
    switch(index + 1, count + 1)
    pressButton(index)
}

private fun pressButton(index: Int) {
    if (index > 0) {
        before[index - 1] = !before[index - 1]
    }
    before[index] = !before[index]
    if (index != n - 1) {
        before[index + 1] = !before[index + 1]
    }
}
