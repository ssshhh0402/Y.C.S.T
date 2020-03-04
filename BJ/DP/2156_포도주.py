import sys

N = int(sys.stdin.readline())
base = [0 for _ in range(N+1)]
for idx in range(1, N+1):
    base[idx] = int(sys.stdin.readline())
result = [0 for _ in range(N+1)]
for day in range(1, N+1):
    if day == 1:
        result[1] = base[1]
    elif day == 2:
        result[day] = base[1] + base[2]
    else:
        result[day] = max(result[day-3]+base[day-1] + base[day], result[day-2]+base[day], result[day-1])
            ## 3일 전 먹고 어제 먹고 오늘먹고, 2일 전 먹고 오늘 먹고,
print(result[N])