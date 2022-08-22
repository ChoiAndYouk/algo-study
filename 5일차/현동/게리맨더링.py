# https://www.acmicpc.net/problem/17471

import sys
from collections import deque
sys.stdin = open("input3.txt", "r") 
input = sys.stdin.readline

def combis(arr, n):
    result = []

    if n > len(arr):
        return result

    if n == 1:
        for i in arr:
            result.append([i])
    
    elif n > 1:
        for i in range(len(arr)-n+1):
            for j in combis(arr[i+1:], n-1):
                result.append([arr[i]] + j)
    
    return result

def bfs(arr):
    visited = [False] * N
    q = deque()
    start = arr[0]
    q.append(start)
    visited[start] = True
    cnt = 0
    result = 0

    while q:
        v = q.popleft()
        cnt += 1
        result += people[v]

        for i in Map[v]:
            if i in arr and not visited[i]:
                q.append(i)
                visited[i] = True
    return cnt, result

N = int(input())
people = list(map(int, input().split()))
Map = [list(map(lambda x: int(x)-1, input().split()))[1:] for _ in range(N)]
result = sys.maxsize

arr = [i for i in range(N)]
for i in range(1,N//2+1):
    for combi in combis(arr, i):
        cnt1, result1 = bfs(combi)
        cnt2, result2 = bfs([i for i in range(N) if i not in combi ])
        if cnt1 + cnt2 == N:
            result = min(result, abs(result1-result2))

if result == sys.maxsize:
    print(-1)
else:
    print(result)