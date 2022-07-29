# https://www.acmicpc.net/problem/1039

import sys
input = sys.stdin.readline

[N, K] = list(input().split())
arr_num = list(N)
max_num = -1
M = len(arr_num)
K = int(K)
memo = [{} for _ in range(K)]

if M == 1 or (M == 2 and arr_num[1] == '0'):
    print(-1)
    exit()

def dfs(arr, cnt):
    global max_num
    if cnt == K:
        return int(''.join(arr))
    if int(''.join(arr)) in memo[cnt]: return memo[cnt][int(''.join(arr))]
    
    for i in range(M):
        for j in range(i+1, M):
            if i == 0 and arr[j] == '0': continue

            arr[i], arr[j] = arr[j], arr[i]
            tmp = dfs(arr, cnt+1)
            arr[i], arr[j] = arr[j], arr[i]
            if int(''.join(arr)) not in memo[cnt]:
                memo[cnt][int(''.join(arr))] = tmp
            else:
                memo[cnt][int(''.join(arr))] = max(tmp, memo[cnt][int(''.join(arr))])
    return memo[cnt][int(''.join(arr))]
print(dfs(arr_num, 0))