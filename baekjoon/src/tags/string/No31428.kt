package tags.string

/**
 * https://www.acmicpc.net/problem/31428
 */
fun main() {
    readln()
    val tracks = readln().split(" ").map { it[0] }.toCharArray()
    val track = readln()[0]
    println(tracks.count { it == track })
}
