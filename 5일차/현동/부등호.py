# https://www.acmicpc.net/problem/2529

import sys
# sys.stdin = open("input2.txt", "r")
input = sys.stdin.readline



N = int(input())
inequlity = input().split()
curMaxNum = 9
strMaxNum = ''
curMinNum = 0
strMinNum = ''

maxCnt = 0
minCnt = 0
for i in range(N):
  if inequlity[i] == '>':
    tmp = ''.join(map(str, range(curMaxNum-maxCnt, curMaxNum+1)))
    strMaxNum += tmp
    curMaxNum = curMaxNum-(maxCnt+1)
    maxCnt = 0

    minCnt += 1

  else:
    maxCnt += 1

    tmp = ''.join(map(str, range(curMinNum+minCnt, curMinNum-1, -1)))
    strMinNum += tmp
    curMinNum = curMinNum+minCnt+1
    minCnt = 0

strMaxNum += ''.join(map(str, range(curMaxNum-maxCnt, curMaxNum+1)))
strMinNum += ''.join(map(str, range(curMinNum+minCnt, curMinNum-1, -1)))

print(strMaxNum)
print(strMinNum)
