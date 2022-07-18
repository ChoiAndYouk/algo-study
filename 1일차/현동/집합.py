# https://www.acmicpc.net/problem/11723

import sys
n = int(sys.stdin.readline())
lis = [False] * 21
for i in range(n):
    temp = sys.stdin.readline().split()
    if len(temp) == 1:
        lis = [True] * 21 if temp[0] == 'all' else [False] * 21
        continue
    
    command, x = temp[0], int(temp[1])
    if command == 'add':
        lis[x] = True
    elif command == 'remove':
        lis[x] = False
    elif command == 'check':
        print(1 if lis[x] else 0)
    elif command == 'toggle':
        lis[x] = False if lis[x] else True