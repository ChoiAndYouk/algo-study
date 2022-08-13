# https://www.acmicpc.net/problem/5567

import sys
sys.stdin = open("input3.txt", "r") 
input = sys.stdin.readline

n = int(input())
v = int(input())
arr = [[] for _ in range(n+1)]
visited = [False] * (n+1)
answer = []

for i in range(v):
  a, b = map(int, input().split())
  arr[a].append(b)
  arr[b].append(a)

def dfs(friend, lv):
  global answer
  if lv == 2:
    return

  for i in arr[friend]:
    if visited[i]: continue
    visited[i] = True
    if not i in answer:
      answer.append(i)
    dfs(i, lv+1)
    visited[i] = False

visited[1] = True
dfs(1, 0)
print(len(answer))