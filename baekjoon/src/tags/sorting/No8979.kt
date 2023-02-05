package tags.sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/8979
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val input = reader.readLine().split(' ').map { it.toInt() }
    val numberOfCountry = input[0]

    val countries = arrayListOf<List<Int>>()
    var targetCountry = listOf<Int>()
    for (i in 0 until numberOfCountry) {
        val medals = reader.readLine().split(' ').map { it.toInt() }
        if (medals[0] == input[1])
            targetCountry = medals
        countries.add(medals)
    }

    var rank = 1
    for (i in countries.indices) {
        val medals = countries[i]
        if (medals[1] > targetCountry[1])
            rank++
        else if (medals[1] == targetCountry[1]) {
            if (medals[2] > targetCountry[2])
                rank++
            else if (medals[2] == targetCountry[2]) {
                if (medals[3] > targetCountry[3])
                    rank++
            }
        }
    }

    writer.write(rank.toString())
    writer.flush()
}

/*
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val input = reader.readLine().split(' ').map { it.toInt() }
    val numberOfCountry = input[0]
    val target = input[1]

    val countries = mutableListOf<List<Int>>()
    for (i in 0 until numberOfCountry) {
        val medals = reader.readLine().split(' ').map { it.toInt() }
        countries.add(medals)
    }
    countries.sortWith(compareBy({ -it[1] }, { -it[2] }, { -it[3] }))

    var rank = 1
    var previousMedals = countries[0]
    for (i in countries.indices) {
        val medals = countries[i]
        if (!(medals[1] == previousMedals[1] && medals[2] == previousMedals[2] && medals[3] == previousMedals[3]))
            rank = i + 1
        previousMedals = countries[i]

        if (medals[0] == target)
            break
    }

    writer.write(rank.toString())
    writer.flush()
}
*/
