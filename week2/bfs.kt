fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()

    val queue = LinkedList<Int>()

    val visited = ArrayList<Vertex<T>>

    fun bfs(start: Int){
        queue.add(start)
        visited[start] = true

        while(queue.inNotEmpty()){
            val head = queue.poll()
            for(next in edges[head]){
                if(!visited[next]){
                    visited[next] = true
                    queue.add(next)
                }
            }
        }
    }
}