package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1026
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine().toInt()
    val firstArray = reader.readLine().split(' ').map { number -> number.toInt() }.sorted().reversed()
    val secondArray = reader.readLine().split(' ').map { number -> number.toInt() }.toTypedArray()

    var sum = 0
    for (i in secondArray.indices)
        sum += secondArray[i] * firstArray[getIndex(i, secondArray)]

    writer.write(sum.toString())
    writer.flush()
}

private fun getIndex(index: Int, array: Array<Int>): Int {
    val number = array[index]
    var count = 0
    for (i in array.indices) {
        if (number > array[i])
            count++
        else if (number == array[i] && index < i)
            count++
    }
    return count
}

//fun main() {
//    val reader = BufferedReader(InputStreamReader(System.`in`))
//    val writer = BufferedWriter(OutputStreamWriter(System.out))
//
//    reader.readLine().toInt()
//    val firstArray = reader.readLine().split(' ').map { number -> number.toInt() }.sorted().reversed()
//    val secondArray = reader.readLine().split(' ').map { number -> number.toInt() }.sorted()
//
//    var sum = 0
//    for (i in firstArray.indices)
//        sum += firstArray[i] * secondArray[i]
//
//    writer.write(sum.toString())
//    writer.flush()
//}
