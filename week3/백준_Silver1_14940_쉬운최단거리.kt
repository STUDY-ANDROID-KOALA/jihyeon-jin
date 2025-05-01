import java.util.StringTokenizer
private data class Coordinate(val x: Int, val y: Int)

/*

Array<Array<Int>>(<- 중첩참조배열) 보다는 Array<IntArray>가 나음 (연속된 메모리 공간 사용)
Pair<Int, Int>보다는 data class로 좌표 저장하는게 나음 -> Kotlin에서는 성능상 Pair는 실제 메모리에 객체로 생성되기 때문에 성능에 영향
LinkedList는 노드 기반, 포인터가 포함되어 더 큼
ArrayDeque는 배열 기반, 내부적인 원형 배열 사용, 연속된 메모리 사용하여 더 빠르고 캐시 효율 좋다,BFS 사용시 적합
br.readLine().split(" ").map { it.toInt() }은 내부 정규식 사용으로 StringTokenizer가 살짝 더 빠름
 */
fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val map = Array(n) { IntArray(m) }
    val finalMap = Array(n) { IntArray(m) { -1 } }
    var start = Coordinate(0, 0)

    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    for (i in 0 until n) {
        val line = StringTokenizer(br.readLine())
        for (j in 0 until m) {
            map[i][j] = line.nextToken().toInt()
            if (map[i][j] == 2) {
                start = Coordinate(i, j)
                map[i][j] = 0
                finalMap[i][j] = 0
            }
            if (map[i][j] == 0) finalMap[i][j] = 0
        }
    }

    val queue = ArrayDeque<Coordinate>()
    queue.add(start)
    while (queue.isNotEmpty()) {
        val head = queue.removeFirst()
        for (i in 0 until 4) {
            val nx = head.x + dx[i]
            val ny = head.y + dy[i]

            if (nx in 0 until n &&
                ny in 0 until m
            ) {
                if (finalMap[nx][ny] == -1 && map[nx][ny] == 1) {
                    finalMap[nx][ny] = finalMap[head.x][head.y] + 1
                    queue.addLast(Coordinate(nx, ny))
                }
            }
        }
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            write("${finalMap[i][j]}${if (j != m - 1) " " else ""}")
        }
        newLine()
    }
    close()
}