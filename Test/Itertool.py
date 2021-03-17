# import itertools
#
# items = [0,1,2]
# answer = []
# for idx in range(1,len(items)+1):
#     answer.append(list(itertools.permutations(items,idx)))
#
#
# for item in answer:
#     for inner in item:
#         for idx in range(len(inner)):
#             print(inner[idx])
inputs =["01/01 4 50000","01/11 6 3555","02/01 0 -23555","02/25 5 5000","03/25 0 -15000","06/09 8 43951","12/30 9 99999"]
s = []


def find(a , b):
    months = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    time = 0
    if a == 1 and b == 1:
        return 0
    else:
        for i in range(1, a):
            time += months[i]

    time += b - 1
    return time

answer = 0
for input in inputs:
    n = input.split(" ")
    dates = n[0].split("/")
    rate = int(n[1])
    money = int(n[2])
    c_date = find(int(dates[0]), int(dates[1]))
    if money < 0:
        while money < 0:
            n_money, n_rate,n_date = s.pop()
            if abs(n_money) < abs(money):
                moneys = (float)(n_money * n_rate) / 100
                dates = (float)(c_date - n_date) / 365
                temps = int(moneys * dates)
                answer += temps

    else:
        s.append((money,rate,c_date))

print(answer)