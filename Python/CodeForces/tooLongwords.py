n = int(input())
for _ in range(n):
    word = input()
    if len(word) <= 10:
        print(word)
    else:
        answer = ''
        answer += word[0]
        answer += str(len(word)-2)
        answer += word[-1]
        print(answer)

