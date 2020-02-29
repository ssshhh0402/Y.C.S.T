import itertools


def solution(numbers):
    n=len(numbers)
    temp_list1=[]
    temp_list2=[]
    # result=[]
    for i in range(1, n+1):
        my_p = itertools.permutations(numbers,i)
        for p in my_p:
            temp_list1.append(p)

    for i in temp_list1:
        x = ('').join(i)
        temp_list2.append(int(x))

    temp_list2=list(set(temp_list2))
    temp_list2.sort()

    count = 0
    for i in temp_list2:
        if i < 2:
            pass
        elif i == 2:
            count += 1
            # result.append(i)
        else:
            for j in range(2, i):
                if i % j == 0:
                    break
                elif j ==i-1:
                    count += 1
                    # result.append(i)
    return count