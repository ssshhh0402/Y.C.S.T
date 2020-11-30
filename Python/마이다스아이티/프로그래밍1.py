from collections import deque


def solution(encrypted_text, key, rotation):
    answer = ''

    base= deque([i for i in encrypted_text])
    base.rotate(-rotation)

    for i in range(len(encrypted_text)):
        now = ord(base[i]) - ord(key[i]) + 96
        if now < 97:
            now += 26
        answer += chr(now)

    return answer


print(solution("qyyigoptvfb", "abcdefghijk",3))