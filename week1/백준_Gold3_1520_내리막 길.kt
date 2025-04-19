fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()

    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(1, -1, 0, 0)

    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(m) { br.readLine().split(" ").map { it.toInt() } }
    val dp = Array(m) { IntArray(n) { -1 } } //메모이제이션 배열


    fun dfs(x: Int, y: Int) : Int {
        if (x == m - 1 && y == n - 1) return 1 //마지막에 도달했으면 1 리턴하여 더해줌

        if (dp[x][y] != -1) return dp[x][y] // 방문했으면 이미 연산한 결과를 리턴

        dp[x][y] = 0 // 처음 방문 했으면 0으로 초기화

        for (i in dx.indices) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until m
                && ny in 0 until n
                && map[nx][ny] < map[x][y]
            ) {
                dp[x][y] += dfs(nx, ny) //이 다음 경로들에 대해 경로의 수를 구한 뒤 저장
            }
        }
        return dp[x][y] //구한 경로의 수를 리턴
    }

    dfs(0,0)
    write(dfs(0,0).toString())
    close()
}
