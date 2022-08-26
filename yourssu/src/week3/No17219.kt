package week3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/17219
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val input = reader.readLine().split(" ").map { it.toInt() }
    val numberOfSitesInMemo = input[0]
    val numberOfSitesToFindPassword = input[1]

    val sites = mutableMapOf<String, String>()
    repeat(numberOfSitesInMemo) {
        val siteAndPassword = reader.readLine().split(" ")
        sites[siteAndPassword[0]] = siteAndPassword[1]
    }

    repeat(numberOfSitesToFindPassword) {
        val site = reader.readLine()
        writer.write(sites[site]!!)
        writer.newLine()
    }

    writer.flush()
}