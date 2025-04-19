import java.util.LinkedList
/*
최단거리 BFS 활용하기
bfs로 최단거리로 물고기 잡아 먹기
-> 먹을 수 있는 물고기 후보 고르기
-> 후보를 추가할 때 후보 중 최단 거리보다 크면 후보에서 제외
-> 후보 중 sort로 count,x, y 순으로 오름차순 정렬해서 그 중 첫번째 거 찾음
-> 해당 후보의 위치를 0으로 바꾸고 eatCount 증가, eatCount가 상어 크기랑 같아지면 상어 커짐
-> 상어 커지면 eatCount 초기화
-> 이동거리만큼 전역 total 수 증가시킴
-> 못찾으면 -1
이 bfs를 이동 위치마다 호출하면서 -1이면 종료하고 최종 거리 return함
*/
fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val v = BooleanArray(3){ false }
    val n = br.readLine().toInt()
    val map = Array(n) { Array(n){ 0 } }
    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(-1, 1, 0, 0)
    var eatCount = 0
    var sharkSize = 2
    var total = 0
    data class State(val x : Int, val y : Int, val count: Int)
    var startState = State(0,0,0)

    for(i in 0 until n){
        val line = br.readLine().split(" ").map { it.toInt() }
        for(j in 0 until n){
            map[i][j] = line[j]
            if(map[i][j] == 9) {
                startState = State(i, j, 0)
                map[i][j] = 0
            }
        }
    }

    fun bfs(x:Int, y:Int) : State {
        val queue = LinkedList<State>()
        val visited = Array(n) { Array(n) { false } }
        val canMove = mutableListOf<State>()
        var minDist = Int.MAX_VALUE
        queue.add(State(x, y, 0))
        visited[x][y] = true
        while (queue.isNotEmpty()) {
            val head = queue.poll()
            if(map[head.x][head.y] in 1 until sharkSize && head.count <= minDist) {
                if (head.count < minDist) {
                    minDist = head.count
                    canMove.clear()
                }
                canMove.add(head)
            }
            for (i in dx.indices) {
                val nx = dx[i] + head.x
                val ny = dy[i] + head.y
                if (nx in 0 until n &&
                    ny in 0 until n &&
                    !visited[nx][ny] &&
                    map[nx][ny] <= sharkSize
                ) {
                    visited[nx][ny] = true
                    queue.add(State(nx, ny, head.count + 1))
                }
            }
        }
        if(canMove.isNotEmpty()) {
            canMove.sortWith(compareBy({ it.count }, { it.x }, { it.y }))
            val target = canMove.first()
            eatCount++
            if (eatCount == sharkSize) {
                sharkSize++
                eatCount = 0
            }
            total += target.count
            map[target.x][target.y] = 0
            return State(target.x, target.y, 0)
        }
        return State(-1, -1, -1)
    }

    while(startState.x != -1) {
        startState = bfs(startState.x, startState.y)
    }
    write(total.toString())
    close()
}