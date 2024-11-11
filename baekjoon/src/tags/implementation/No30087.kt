package tags.implementation

/**
 * https://www.acmicpc.net/problem/30087
 */
fun main() {
    val seminars = mapOf(
        "Algorithm" to "204",
        "DataAnalysis" to "207",
        "ArtificialIntelligence" to "302",
        "CyberSecurity" to "B101",
        "Network" to "303",
        "Startup" to "501",
        "TestStrategy" to "105"
    )

    val n = readln().toInt()
    repeat(n) {
        val seminar = readln()
        println(seminars[seminar])
    }
}
