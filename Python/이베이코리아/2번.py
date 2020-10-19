def solution(num, cards):
    answer = -1
    cards.sort(reverse=True)
    idx = 0
    while idx < len(cards):
        temps = num
        used = 0
        if cards[idx] == temps:
            return 1
        elif cards[idx] < temps:
            p = temps // cards[idx]
            temps = temps % cards[idx]
            used += p
            if not temps:
                if answer < 0:
                    answer = used
                else:
                    answer = min(answer, used)
            else:
                idx_2 = idx + 1
                for j in range(idx_2, len(cards)):
                    p = temps // cards[j]
                    temps = temps % cards[j]
                    used += p
                    if not temps:
                        if answer < 0:
                            answer = used
                        else:
                            answer = min(answer,used)
                        break


        idx += 1

    return answer
# print(solution(8, [1,4,6]))
print(solution(18, [1, 2, 5]))