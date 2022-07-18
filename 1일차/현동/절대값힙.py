# https://www.acmicpc.net/problem/11286

import heapq
import sys

n = int(sys.stdin.readline())
heap_plus = []
heap_minus = []
for _ in range(n):
    x = int(sys.stdin.readline())
    if x > 0:
        heapq.heappush(heap_plus, x)
    elif x < 0:
        heapq.heappush(heap_minus, -x)
    else:
        if not heap_plus and not heap_minus:
            print(0)
        elif heap_plus and not heap_minus:
            print(heapq.heappop(heap_plus))
        elif not heap_plus and heap_minus:
            print(-heapq.heappop(heap_minus))
        elif heap_plus and heap_minus:
            plus = heap_plus[0]
            minus = heap_minus[0]
            if plus < minus:
                print(heapq.heappop(heap_plus))
            else:
                print(-heapq.heappop(heap_minus))
        

