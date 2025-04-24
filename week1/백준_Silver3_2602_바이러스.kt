val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val c = br.readLine().toInt()
    val visited = BooleanArray(n + 1)
    val graph = Array(n+1){ arrayListOf<Int>() }
    var cnt = 0

    repeat(c) {
        val (node, linkedNode) = br.readLine().split(" ").map { it.toInt() }
        graph[node].add(linkedNode)
        graph[linkedNode].add(node)
    }

    fun dfs(node: Int) {
        visited[node] = true

        for(next in graph[node]){
            if(!visited[next]) {
                cnt++
                dfs(next)
            }
        }
    }

    dfs(1)
    write(cnt.toString())
    close()

}
