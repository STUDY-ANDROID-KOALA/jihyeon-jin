fun main() {
    val sv = Solution2()
    val tickets = arrayOf(
        arrayOf("ICN", "SFO"),
        arrayOf("ICN", "ATL"),
        arrayOf("SFO", "ATL"),
        arrayOf("ATL", "ICN"),
        arrayOf("ATL", "SFO")
    )
    sv.solution(tickets = tickets)

}
/*
모든 경로 탐색 DFS + 백트래킹 사용
티켓 수 + 1이 경로의 수 -> 이때 라우트 리스트에 추가
얕은 복사 주의 (routes.add(route)) -> 얕은 복사
(routes.add(ArrayList(route))) -> 깊은 복사
혹은 val routes = mutableListOf<List<String>>()
routes.add(route.toList()) 하면 깊은 복사
sortBy({it.joinToString(seperator="")})
sortWith(compareBy{ it.joinToStrong("") })
둘 다 단어 연결함 구분자 명시 안하면 ,가 포함됨
val routes = PriorityQueue<List<String>>(compareBy{ it.joinToString("") })
이렇게 선언하면 sort 없이 poll한게 정답임
 */
class Solution2 {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val ticketCount = tickets.count()
        val visited = BooleanArray(ticketCount) { false }

        val route = mutableList<String>()
        val routes = ArrayList<ArrayList<String>>()
        route.add("ICN")

        fun dfs(destination: String, route: ArrayList<String>) {
            if (route.size == ticketCount + 1) {
                routes.add(route.toList() as ArrayList<String>)
                return
            }
            for (i in tickets.indices) {
                if (!visited[i] &&
                    destination == tickets[i][0]
                ) {
                    visited[i] = true
                    route.add(tickets[i][1])
                    dfs(tickets[i][1], route)
                    route.removeAt(route.lastIndex)
                    visited[i] = false
                }
            }
        }
        dfs("ICN", route)
        routes.sortBy { it.joinToString() }
        return routes[0].toList().toTypedArray()
    }
}
