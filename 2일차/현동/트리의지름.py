# https://www.acmicpc.net/problem/1167
import sys

sys.stdin = open("input3.txt", "r") 
input = sys.stdin.readline

def dfs(node, distance):
    global result, N, start_node
    visited[node] = True
    if result < distance:
        start_node = node
        result = distance
    for n, d in Map[node]:
        if visited[n]: continue
        dfs(n, distance+d)

N = int(input())
Map = [[] for _ in range(N+1)]
start_node = 1
result = 0
for _ in range(N):
    order = list(map(int, input().split()))
    i = 1
    while order[i] != -1:
        Map[order[0]].append([order[i], order[i+1]])
        Map[order[i]].append([order[0], order[i+1]])
        i += 2
        
visited = [False] * (N+1)
dfs(1, 0)
visited = [False] * (N+1)
dfs(start_node, 0)

print(result)