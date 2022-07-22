# https://www.acmicpc.net/problem/1043

import sys

sys.stdin = open("input2.txt", "r") 
input = sys.stdin.readline

N, M = map(int, input().split())
n = list(map(int, input().split()))
if n[0] == 0:
    print(M)
else:
    n = set(n[1:])
    party = []
    for p in range(M):
        party.append(set(list(map(int, input().split()))[1:]))

    while True:
        flag = False
        for i in range(len(party)):
            if (party[i] & n):
                n.update(party[i])
                party.pop(i)
                flag = True
                break
        if flag: continue
        break

    print(len(party))