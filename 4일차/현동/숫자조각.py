# https://www.acmicpc.net/problem/14629

import sys
input = sys.stdin.readline

def dfs(num, lv, limit):
  global answer, diff

  if lv >= limit:
    tmp = int(num)
    result = abs(tmp-N)
    if diff > result:
      diff = result
      answer = num
    return

  for i in range(10):
    if visited[i]: continue
    visited[i] = True
    dfs(num+str(i), lv+1, limit)
    visited[i] = False

N = int(input())
nStr = str(N)
size = len(str(N))
visited = [False] * 10
diff = sys.maxsize
answer = ''

if N >= 9876543210: 
  print(9876543210)
elif N < 11:
  print(N)
else:
  if size!=2:
    visited[9] = True
    dfs('9', 0, size-2)
    visited[9] = False

  visited[int(nStr[0])] = True
  dfs(nStr[0], 0, size-1)
  visited[int(nStr[0])] = False

  if size!=10:
    visited[1] = True
    dfs('1', 0, size)
    visited[1] = False
  print(answer)