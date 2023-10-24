package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/11723
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val m = reader.readLine().toInt()
    repeat(m) {
        val command = reader.readLine().split(" ")
        when (command[0]) {
            "add" -> add(command[1].toInt())
            "remove" -> remove(command[1].toInt())
            "check" -> writer.write("${check(command[1].toInt())}\n")
            "toggle" -> toggle(command[1].toInt())
            "all" -> all()
            "empty" -> empty()
        }
    }
    writer.flush()
}

private val s = BooleanArray(21)

private fun add(x: Int) {
    s[x] = true
}

private fun remove(x: Int) {
    s[x] = false
}

private fun check(x: Int): Int {
    return if (s[x]) {
        1
    } else {
        0
    }
}

private fun toggle(x: Int) {
    s[x] = !s[x]
}

private fun all() {
    (1..20).forEach { i -> s[i] = true }
}

private fun empty() {
    (1..20).forEach { i -> s[i] = false }
}
