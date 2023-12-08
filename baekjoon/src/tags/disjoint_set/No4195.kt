package tags.disjoint_set

/**
 * https://www.acmicpc.net/problem/4195
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var names: MutableMap<String, Int>
private lateinit var parents: MutableList<Int>
private lateinit var counts: MutableList<Int>

fun main() {
    val t = reader.readLine().toInt()
    repeat(t) {
        names = mutableMapOf()
        parents = mutableListOf()
        counts = mutableListOf()

        val f = reader.readLine().toInt()
        repeat(f) {
            val (a, b) = reader.readLine().split(" ")
            if (!names.containsKey(a)) {
                parents.add(names.size)
                counts.add(1)
                names[a] = names.size
            }
            if (!names.containsKey(b)) {
                parents.add(names.size)
                counts.add(1)
                names[b] = names.size
            }

            writer.write("${union(names[a]!!, names[b]!!)}\n")
        }
        writer.flush()
    }
}

private fun union(a: Int, b: Int): Int {
    val parentA = find(a)
    val parentB = find(b)
    if (parentA != parentB) {
        counts[parentA] += counts[parentB]
        counts[parentB] = counts[parentA]
        parents[parentA] = parentB
    }
    return counts[parentA]
}

private fun find(n: Int): Int {
    if (parents[n] != n) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}
