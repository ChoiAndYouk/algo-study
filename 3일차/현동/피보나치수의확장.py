import sys

input = sys.stdin.readline

N = int(input())
dp = [0] * (abs(N)+2)
dp[0], dp[1] = 0, 1

if N > 0:
    for i in range(2, N+1):
        dp[i] = (dp[i-1] + dp[i-2]) % 1000000000
    print(1)
    print(dp[N])

elif N == 0:
    print(0)
    print(0)

else:
    for i in range(-1, N-1, -1):
        tmp = dp[i+2] - dp[i+1]
        if tmp < 0:
            dp[i] = (abs(tmp) % 1000000000) * -1
        else:
            dp[i] = tmp % 1000000000

    if dp[N] < 0:
        print(-1)
    else:
        print(1)
    print(abs(dp[N]))

