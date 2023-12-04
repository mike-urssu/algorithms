package tags.recursion

/**
 * https://www.acmicpc.net/problem/4779
 */
import kotlin.math.pow

private lateinit var cantor: BooleanArray

fun main() {
    while (true) {
        val n = (readlnOrNull() ?: break).toInt()
        val length = 3.0.pow(n.toDouble()).toInt()
        cantor = BooleanArray(length) { true }
        setCantor(length, 0, length - 1)
        printCantor()
    }
}

private fun setCantor(length: Int, start: Int, end: Int) {
    if (length == 1) {
        return
    }

    val chunk = length / 3
    (start + chunk until start + chunk * 2).forEach { i -> cantor[i] = false }
    setCantor(length / 3, start, start + chunk)
    setCantor(length / 3, start + chunk * 2, end)
}

private fun printCantor() {
    val string = StringBuilder()
    cantor.forEach {
        if (it) {
            string.append("-")
        } else {
            string.append(" ")
        }
    }
    println(string)
}
