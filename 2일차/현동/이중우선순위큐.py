import sys
import heapq

sys.stdin = open("input1.txt", "r") 
input = sys.stdin.readline

for _test in range(int(input())):
    n = int(input())
    max_q = []
    min_q = []
    visited = [False] * n
    for i in range(n):
        order, value = input().split()
        value = int(value)
        if order == 'I':
            heapq.heappush(max_q, (-value, i))
            heapq.heappush(min_q, (value, i))
            visited[i] = True

        elif order == 'D':
            if value == 1:
                while max_q and not visited[max_q[0][1]]:
                    heapq.heappop(max_q)
                if max_q:
                    visited[max_q[0][1]] = False
                    heapq.heappop(max_q)

            elif value == -1:
                while min_q and not visited[min_q[0][1]]:
                    heapq.heappop(min_q)
                if min_q:
                    visited[min_q[0][1]] = False
                    heapq.heappop(min_q)
                    
    while max_q and not visited[max_q[0][1]]:
        heapq.heappop(max_q)
    while min_q and not visited[min_q[0][1]]:
        heapq.heappop(min_q)
    if not max_q or not min_q:
        print('EMPTY')
    else:
        print(-max_q[0][0], min_q[0][0])

