package level.bronze5

import java.time.Clock
import java.time.LocalDate

/**
 * https://www.acmicpc.net/problem/10699
 */
fun main() {
    println(LocalDate.now(Clock.systemDefaultZone()))
}