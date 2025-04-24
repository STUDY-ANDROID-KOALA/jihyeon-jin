fun main() = with(System.out.bufferedWriter()) {
    data class Coordinate(val x: Int, val y: Int)

    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { CharArray(m) }
    var start = Coordinate(0, 0)
    var count = 0
    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(-1, 1, 0, 0)

    for (i in 0 until n) {
        val line = br.readLine()
        for (j in 0 until m) {
            map[i][j] = line[j]
            if (map[i][j] == 'I')
                start = Coordinate(i, j)
        }
    }

    val queue = ArrayDeque<Coordinate>()
    val visited = Array(n) { BooleanArray(m) { false } }
    queue.addLast(start)
    visited[start.x][start.y] = true

    while (queue.isNotEmpty()){
        val head = queue.removeFirst()

        if(map[head.x][head.y] == 'P'){
            count++
        }
        for(i in 0 until 4){
            val nx = head.x + dx[i]
            val ny = head.y + dy[i]

            if(nx in 0 until n &&
                ny in 0 until m &&
                !visited[nx][ny] &&
                map[nx][ny] != 'X'){
                visited[nx][ny] = true
                queue.addLast(Coordinate(nx, ny))
            }
        }
    }

    write("${if(count == 0) "TT" else count}")
    close()
}