def find(my, dealer, cards):
    global answer
    mysum= 0            # 1
    mysum2 = 0             # 11
    for card in my:
        if card == 1:
            mysum += 1
            mysum2 += 11
        elif card > 10:
            mysum += 10
            mysum2 += 10
        else:
            mysum += card
            mysum2 += card
    if mysum == 21 or mysum2 == 21:
        answer += 3
    elif mysum > 21 and mysum2 > 21:
        answer -= 2
    else:
        # 계속 받는부분
        if dealer[-1] == 1 or dealer[-1] >= 7:
            seventen()
        elif dealer[-1] in [4,5,6]:
            #더 안받음
        elif dealer[-1] in [2,3]:
            #합 12 될때가







def solution(cards):
    global answer
    answer = 0
    idx = 0
    my = []
    dealer = []
    while idx != 4:
        card = cards[idx]
        if idx % 2 == 0:
            my.append(card)
        else:
            dealer.append(card)
    find(my, dealer, cards)


print(solution([12, 7, 11, 6, 2, 12]))
print(solution([1, 4, 10, 6, 9, 1, 8, 13]))
print(solution([10, 13, 10, 1, 2, 3, 4, 5, 6, 2]))
print(solution([3, 3, 3, 3, 3, 3, 3, 3, 3, 3]))