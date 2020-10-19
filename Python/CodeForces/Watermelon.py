answer = False
n = int(input())
for idx in range(1, n // 2 + 1):
    target = n - idx
    if idx % 2 == 0 and target % 2 == 0:
        answer = True
        break
if answer:
    print("YES")
else:
    print("NO")