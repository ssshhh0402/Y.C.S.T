def find(target, base):
    flag = True
    temps = 0
    now = base
    for char in target:
        if char not in now:
            flag = False
            break
        else:
            temps = now[char]['count']
            now = now[char]
    if not flag:
        return "0"
    else:
        return temps


n = int(input())
dicts = {}
for _ in range(n):
    word = input()
    now = dicts
    for char in word:
        if char not in now:
            now[char] = {'count': 1}
        else:
            now[char]['count'] += 1
        now = now[char]


m =int(input())
answer = ""
for _ in range(m):
    target = input()
    answer += str(find(target, dicts)) + "\n"
print(answer)
