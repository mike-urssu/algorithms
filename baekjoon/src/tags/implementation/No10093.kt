package tags.implementation

/**
 * https://www.acmicpc.net/problem/10093
 */
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.math.BigInteger

private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var (a, b) = readln().split(" ").map { it.toBigInteger() }.sorted()

    val numbers = StringBuilder()
    var count = 0

    a += BigInteger.ONE
    while (a.compareTo(b) == -1) {
        numbers.append("$a ")
        a += BigInteger.ONE
        count++
    }

    writer.write("$count\n")
    writer.write(numbers.toString())
    writer.flush()
}
