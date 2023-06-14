package tags.string

/**
 * https://www.acmicpc.net/problem/2804
 */
fun main() {
    val (a, b) = readln().split(" ")
    val commonChar = getCommonChar(a, b)
    getGraph(a, b, commonChar).forEach { println(it) }
}

private fun getCommonChar(a: String, b: String): Char {
    var char = '-'
    for (i in a.indices) {
        if (b.indexOf(a[i]) != -1) {
            char = a[i]
            break
        }
    }
    return char
}

private fun getGraph(a: String, b: String, commonChar: Char): Array<CharArray> {
    val aIndex = a.indexOf(commonChar)
    val bIndex = b.indexOf(commonChar)

    val graph = Array(b.length) { CharArray(a.length) { '.' } }
    graph[bIndex] = a.toCharArray()
    b.indices.forEach { i -> graph[i][aIndex] = b[i] }
    return graph
}
