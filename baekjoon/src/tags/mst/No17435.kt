package tags.mst

/**
 * https://www.acmicpc.net/problem/17435
 */
import java.io.BufferedWriter
import java.io.OutputStreamWriter

private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var sparseTable: Array<IntArray>

fun main() {
    val m = readln().toInt()
    sparseTable = getSparseTable(m)

    val q = readln().toInt()
    repeat(q) {
        val (n, x) = readln().split(" ").map { it.toInt() }
        writer.write("${f(n, x)}\n")
    }
    writer.flush()
}

private fun getSparseTable(m: Int): Array<IntArray> {
    val sparseTable = Array(19) { IntArray(m + 1) }
    readln().split(" ").map { it.toInt() }.toIntArray().copyInto(sparseTable[0], 1)
    (1..18).forEach { i ->
        (1..m).forEach { j ->
            sparseTable[i][j] = sparseTable[i - 1][sparseTable[i - 1][j]]
        }
    }
    return sparseTable
}

private fun f(n: Int, x: Int): Int {
    var result = x
    val binary = Integer.toBinaryString(n)
    binary.forEachIndexed { index, digit ->
        if (digit == '1') {
            val rowIndex = binary.length - 1 - index
            result = sparseTable[rowIndex][result]
        }
    }
    return result
}
