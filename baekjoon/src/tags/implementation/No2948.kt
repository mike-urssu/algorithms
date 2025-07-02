package tags.implementation

/**
 * https://www.acmicpc.net/problem/2948
 */
import java.time.LocalDate

fun main() {
    val (d, m) = readln().split(" ").map { it.toInt() }
    val date = LocalDate.of(2009, m, d)
    val dayOfWeek = date.dayOfWeek.name
    println(dayOfWeek[0] + dayOfWeek.lowercase().substring(1))
}
