package com.koala.study.serious.week1

import java.util.LinkedList

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { br.readLine().chunked(1).map{ it.toInt() } }
    var count = Int.MAX_VALUE

    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(-1, 1, 0, 0)

    data class State(val x: Int, val y: Int, val count: Int)

    val queue = LinkedList<State>()
    val visited = Array(n) { BooleanArray(m) { false } }

    fun bfs(x: Int, y: Int) {
        visited[x][y] = true
        queue.add(State(x, y, 1))

        while(queue.isNotEmpty()){
            val head = queue.poll()
            if(head.x == n -1 && head.y == m -1){
                count = minOf(count, head.count)
                return
            }
            for(i in 0 until 4){
                val nx = head.x + dx[i]
                val ny = head.y + dy[i]
                if(nx in 0 until n &&
                    ny in 0 until m &&
                    !visited[nx][ny] &&
                    map[nx][ny] != 0) {
                    visited[nx][ny] = true
                    queue.add(State(nx, ny, head.count + 1))
                }
            }
        }
    }

    bfs(0,0)
    write(count.toString())
    close()
}