package tags.greedy

/**
 * https://www.acmicpc.net/problem/1969
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val dnaList = Array(n) { readln() }
    val dna = getDna(m, dnaList)
    println(dna)
    println(getHammingDistance(m, dna, dnaList))
}

private fun getDna(m: Int, dnaList: Array<String>) =
    (0 until m).map { i ->
        val characters = dnaList.map { it[i] }.groupingBy { it }.eachCount().toSortedMap()
        characters.keys.find { characters[it] == characters.values.max() }!!.toChar()
    }.joinToString("")

private fun getHammingDistance(m: Int, dna: String, dnaList: Array<String>) =
    dnaList.sumOf { (0 until m).count { i -> it[i] != dna[i] } }
