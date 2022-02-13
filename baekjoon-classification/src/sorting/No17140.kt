package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * https://www.acmicpc.net/problem/17140
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val input = reader.readLine().split(' ').map { it.toInt() }
    val row = input[0] - 1
    val col = input[1] - 1
    val targetNumber = input[2]

    var graph = arrayListOf<IntArray>()
    for (i in 0 until 3)
        graph.add(reader.readLine().split(' ').map { it.toInt() }.toIntArray())

    var count = 0
    while (count <= 100) {
        if (graph.size > row && graph[0].size > col && graph[row][col] == targetNumber)
            break
        graph = getNewGraph(graph) as ArrayList<IntArray>
        count++
    }

    writer.write(if (count == 101) "-1" else count.toString())
    writer.flush()
}

private fun getNewGraph(graph: List<IntArray>): List<IntArray> {
    return if (graph.size >= graph[0].size)
        getRGraph(graph)
    else
        getCGraph(graph)
}

private fun getRGraph(graph: List<IntArray>): List<IntArray> {
    val mapOfRows = arrayListOf<Map<Int, Int>>()
    for (row in graph) {
        val countOfNumbers = HashMap<Int, Int>()
        for (number in row) {
            if (number != 0)
                countOfNumbers[number] = countOfNumbers.getOrDefault(number, 0) + 1
        }
        mapOfRows.add(countOfNumbers)
    }

    var maxSizeOfMapOfRows = 0
    for (map in mapOfRows)
        maxSizeOfMapOfRows = maxSizeOfMapOfRows.coerceAtLeast(map.size)

    val sizeOfRow = graph.size.coerceAtMost(100)
    val newGraph = arrayListOf<IntArray>()
    for (i in 0 until sizeOfRow)
        newGraph.add(IntArray(maxSizeOfMapOfRows * 2))

    for ((rowIndex, map) in mapOfRows.withIndex()) {
        val sortedMap = getSortedMap(map)
        for ((colIndex, entry) in sortedMap.entries.withIndex()) {
            newGraph[rowIndex][colIndex * 2] = entry.key
            newGraph[rowIndex][colIndex * 2 + 1] = entry.value
        }
    }
    return newGraph
}

private fun getCGraph(graph: List<IntArray>): List<IntArray> {
    val mapOfCols = arrayListOf<Map<Int, Int>>()
    for (col in 0 until graph[0].size) {
        val countOfNumbers = HashMap<Int, Int>()
        for (row in graph.indices) {
            val number = graph[row][col]
            if (number != 0)
                countOfNumbers[number] = countOfNumbers.getOrDefault(number, 0) + 1
        }
        mapOfCols.add(countOfNumbers)
    }

    var maxSizeOfMapOfCols = 0
    for (map in mapOfCols)
        maxSizeOfMapOfCols = maxSizeOfMapOfCols.coerceAtLeast(map.size)

    val colSize = graph[0].size.coerceAtMost(100)
    val newGraph = arrayListOf<IntArray>()
    for (i in 0 until maxSizeOfMapOfCols * 2)
        newGraph.add(IntArray(colSize))

    for ((colIndex, map) in mapOfCols.withIndex()) {
        val sortedMap = getSortedMap(map)
        for ((rowIndex, entry) in sortedMap.entries.withIndex()) {
            newGraph[rowIndex * 2][colIndex] = entry.key
            newGraph[rowIndex * 2 + 1][colIndex] = entry.value
        }
    }
    return newGraph
}

private fun getSortedMap(map: Map<Int, Int>): SortedMap<Int, Int> = map.toSortedMap { it, other ->
    val valueOfIt = map[it]!!
    val valueOfOther = map[other]!!
    if (valueOfIt == valueOfOther)
        it.compareTo(other)
    else
        valueOfIt.compareTo(valueOfOther)
}
