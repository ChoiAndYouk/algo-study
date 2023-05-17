import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

private var N = 0
private var M = 0

private var isVisited: BooleanArray = BooleanArray(50_001)
private var parent: IntArray = IntArray(50_001)
private var depth: IntArray = IntArray(50_001)

// 인접 리스트
private lateinit var adjustList: ArrayList<ArrayList<Int>>

private data class Node3(
    var v: Int?, var link: Int?
) // End of Node class

fun main() {
    val path = "C:\\Users\\multicampus\\Desktop\\Free PJT Algorithm\\untitled\\src\\main\\resources\\11437.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()
    var st: StringTokenizer

    N = br.readLine().toInt()
    init()

    for (i in 1 until N) {
        st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()

        adjustList[start].add(end)
        adjustList[end].add(start)
    }

    BFS(1, 0)

    M = br.readLine().toInt()
    for (i in 0 until M) {
        st = StringTokenizer(br.readLine())
        sb.append(LCA(st.nextToken().toInt(), st.nextToken().toInt()))
        sb.append('\n')
    }

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun BFS(v: Int, d: Int) {
    val que: Queue<Int> = LinkedList()
    que.offer(v)
    depth[v] = d
    parent[v] = d

    // BFS탐색을 통해서 자신의 부모 노드와, 트리의 깊이를 저장한다.
    while (que.isNotEmpty()) {
        val pollNode = que.poll()
        isVisited[pollNode] = true

        for (i in 0 until adjustList[pollNode].size) {
            var child: Int = adjustList[pollNode][i]
            if (!isVisited[child]) {
                parent[child] = pollNode
                depth[child] = depth[pollNode] + 1
                que.offer(child)
            }
        }
    }
} // End of DFS

private fun LCA(node1: Int, node2: Int): Int {
    println("=============================================================")
    println("LCA($node1, $node2)")
    var node1 = node1
    var node2 = node2

    // 트리의 깊이가 다르면 깊이를 같을 때까지 맞춰줌.
    while (depth[node1] != depth[node2]) {
        println("depth[$node1] = ${depth[node1]}, depth[$node2] = ${depth[node2]}")
        if (depth[node1] > depth[node2]) {
            node1 = parent[node1]
        } else {
            node2 = parent[node2]
        }
    }

    // 깊이가 같아지면 한칸씩 올라가면서 부모가 같은지 찾아봄
    // 둘의 부모가 다르면 같을 때까지 반복해서 찾음
    while (node1 != node2) {
        println("before : node1 $node1 , node2 : $node2")
        node1 = parent[node1]
        node2 = parent[node2]
        println("after : node1 : $node1 , node2 : $node2")
    }

    return node1
} // End of LCA

private fun init() {
    parent = IntArray(N + 1)
    depth = IntArray(N + 1)
    isVisited = BooleanArray(N + 1)

    adjustList = ArrayList()
    for (i in 0..N + 1) {
        adjustList.add(ArrayList())
    }
} // End of init
