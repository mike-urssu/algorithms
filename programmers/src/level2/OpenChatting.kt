package level2

class OpenChatting {
    fun solution(record: Array<String>): Array<String> {
        val users = HashMap<String, String>()
        for (input in record) {
            val info = input.split(' ')
            if (info[0] == "Enter" || info[0] == "Change")
                users[info[1]] = info[2]
        }

        val answer = arrayListOf<String>()
        for (input in record) {
            val info = input.split(' ')
            if (info[0] == "Enter")
                answer.add("${users[info[1]]!!}님이 들어왔습니다.")
            else if (info[0] == "Leave")
                answer.add("${users[info[1]]!!}님이 나갔습니다.")
        }
        return answer.toTypedArray()
    }
}

fun main() {
    val solution = OpenChatting()
    for (result in solution.solution(
        arrayOf(
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        )
    )) {
        println(result)
    }
}
