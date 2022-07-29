# https://www.acmicpc.net/problem/1038

import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

if N == 0: 
    print(0)
    exit()

q = deque([1,2,3,4,5,6,7,8,9])
cnt = 0
n = 0

while q:
    n = q.popleft()
    cnt += 1
    
    if cnt == N:
        print(n)
        exit()

    for i in range(n%10):
        q.append(n*10 + i)

print(-1)





