package tags.implementation

/**
 * https://www.acmicpc.net/problem/34691
 */
fun main() {
    while (true) {
        val s = readln()
        if (s == "end") {
            break
        }
        val v = when (s) {
            "animal" -> "Panthera tigris"
            "tree" -> "Pinus densiflora"
            else -> "Forsythia koreana"
        }
        println(v)
    }
}
