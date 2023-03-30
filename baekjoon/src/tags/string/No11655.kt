package tags.string

/**
 * https://www.acmicpc.net/problem/11655
 */
fun main() {
    val lowerCases = ('a'..'z').toList()
    val upperCases = ('A'..'Z').toList()

    val s = readln()
    val rot13 = s.map {
        if (it.isDigit() || it == ' ') {
            it
        } else if (it.isLowerCase()) {
            lowerCases[(lowerCases.indexOf(it) + 13) % 26]
        } else {
            upperCases[(upperCases.indexOf(it) + 13) % 26]
        }
    }.joinToString("")
    println(rot13)
}
