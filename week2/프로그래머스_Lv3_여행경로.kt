package com.koala.study.serious.week1

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

class Solution2 {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val ticketCount = tickets.count()
        val visited = BooleanArray(ticketCount) { false }

        val route = arrayListOf<String>()
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