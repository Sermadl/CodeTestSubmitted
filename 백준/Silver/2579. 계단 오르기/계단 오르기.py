import sys

stairs = int(input())
dp = [0] * 301
score = [0] * 301

for i in range(stairs):
    score[i] = int(sys.stdin.readline())

dp[0] = score[0]
dp[1] = score[0] + score[1]
dp[2] = max(score[1] + score[2], score[0] + score[2])

for i in range(3, stairs):
    dp[i] = max(dp[i - 3] + score[i - 1] + score[i], dp[i - 2] + score[i])

print(dp[stairs - 1])
