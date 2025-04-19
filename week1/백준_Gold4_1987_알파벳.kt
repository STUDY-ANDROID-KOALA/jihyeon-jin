fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(r) { br.readLine().toCharArray()}
    val visited = BooleanArray(26){ false }
    var maxCount = 0
    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    fun dfs(x: Int, y: Int, cnt: Int){
        maxCount = maxOf(cnt, maxCount)
        visited[board[x][y] - 'A'] = true
        for(i in dx.indices){
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx in 0 until r
                && ny in 0 until c
                && !visited[board[nx][ny] - 'A']
              ) {
                dfs(nx, ny, cnt + 1)
            }
        }
        visited[board[x][y] - 'A'] = false
    }
    dfs(0,0,1)
    write(maxCount.toString())
    close()
}
