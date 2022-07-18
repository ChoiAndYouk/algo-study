# https://www.acmicpc.net/problem/16236

import sys
from collections import deque

input = sys.stdin.readline

dy = [-1, 0, 0, 1]
dx = [0, -1, 1, 0]

def bfs(sy, sx, lv):
    distance = [[-1] * n for _ in range(n)]
    q = deque()
    q.append((sy,sx))
    distance[sy][sx] = 0
    temp = []
    
    while q:
        cur_y, cur_x = q.popleft()
        for i in range(4):
            ny = cur_y + dy[i]
            nx = cur_x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= n: continue
            if distance[ny][nx] != -1: continue
            distance[ny][nx] = distance[cur_y][cur_x] + 1
            if Map[ny][nx] != 0 and Map[ny][nx] < lv: temp.append((ny, nx, distance[ny][nx]))
            if Map[ny][nx] == 0 or Map[ny][nx] == lv: 
                q.append((ny, nx))
    
    if temp:
        return sorted(temp,key=lambda x: (-x[2],-x[0],-x[1])).pop()
    else:
        return False

n = int(input())
Map = [list(map(int, input().split())) for _ in range(n)]
result = 0
sx = -1
sy = -1
lv = 2
for y in range(n):
    for x in range(n):
        if Map[y][x] == 9:
            sy = y
            sx = x

Map[sy][sx] = 0
cnt = 0
while True:
    temp = bfs(sy, sx, lv)
    if temp:
        cnt += 1
        if cnt == lv:
            lv += 1
            cnt = 0
        sy = temp[0]
        sx = temp[1]
        result += temp[2]
        Map[sy][sx] = 0
    else:
        break
print(result)
