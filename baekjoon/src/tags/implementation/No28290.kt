package tags.implementation

/**
 * https://www.acmicpc.net/problem/28290
 */
fun main() {
    val s = readln()
    val type = when (s) {
        "fdsajkl;", "jkl;fdsa" -> "in-out"
        "asdf;lkj", ";lkjasdf" -> "out-in"
        "asdfjkl;" -> "stairs"
        ";lkjfdsa" -> "reverse"
        else -> "molu"
    }
    println(type)
}
