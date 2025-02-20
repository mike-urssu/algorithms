package tags.string

/**
 * https://www.acmicpc.net/problem/10173
 */
fun main() {
    while (true) {
        val s = readln()
        if (s == "EOI") {
            break
        }

        if (s.lowercase().contains("nemo")) {
            println("Found")
        } else {
            println("Missing")
        }
    }
}
