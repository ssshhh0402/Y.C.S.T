N, M = list(map(int, input().split()))
A = list(map(int, input().split()))
start = 0
end = 0
hap, answer = A[0], 0
while start <= end and end < N:
    if hap == M:
        answer += 1
        end += 1
        if hap < N:
            hap += A[end]
    elif hap < M:
        end += 1
        if end < N:
            hap += A[end]
    elif hap > M:
        hap -= A[start]
        start += 1
        if start > end and start < N:
            end = start
            hap = A[start]

print(answer)
N, M = map(int, input().split())
A = list(map(int, input().split()))
left, right, hap, count = 0, 0, A[0], 0
while right < N and left <= right:
    if hap == M:
        count += 1
        right += 1
        if right < N:
            hap += A[right]
    elif hap > M:
        hap -= A[left]
        left += 1
        if left > right and left < N:
            right = left
            hap = A[left]
    elif hap < M:
        right += 1
        if right < N:
            hap += A[right]
print(count)