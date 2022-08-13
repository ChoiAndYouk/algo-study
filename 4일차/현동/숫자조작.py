# https://www.acmicpc.net/problem/14629

import sys
input = sys.stdin.readline

N = int(input())
numArr = list(str(N))
size = len(numArr)
visited = [False] * 10
diff = 9999999999
answer = 9999999999

if N >= 9876543210: 
  print(9876543210)
  exit()
if N <= 10:
  print(N)
  exit()

def dfs(num, lv, limit):
  global answer, diff
  if lv == limit:
    # print(num)
    if diff > abs(num-N):
      diff = abs(num-N)
      answer = num
    return

  for i in range(10):
    if visited[i]: continue
    visited[i] = True
    dfs(num*10+i, lv+1, limit)
    visited[i] = False


# tmp = 0
# for i in range(size):
#   if visited[int(numArr[i])]:
#     dfs(tmp, i, size)
#     break
#   visited[int(numArr[i])] = True
#   tmp = tmp * 10 + int(numArr[i])

dfs(0, 0, size)

if size < 10:
  visited[1] = True
  dfs(1, 0, size)

if size > 2:
  visited[9] = True
  dfs(9, 1, size-1)

print(answer)