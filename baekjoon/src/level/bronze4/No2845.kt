package level.bronze4

/**
 * https://www.acmicpc.net/problem/2845
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (peopleInUnitArea, area) = reader.readLine().split(" ").map { it.toInt() }
    val people = peopleInUnitArea * area

    val peopleInArticles = reader.readLine().split(" ").map { it.toInt() }
    peopleInArticles.forEach { peopleInArticle -> writer.write("${peopleInArticle - people} ") }
    writer.flush()
}
