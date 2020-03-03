# import itertools
#
#
# def get(arrs):
#     comp = []
#     for item in arrs:
#         if item not in comp:
#             comp.append(item)
#     return len(comp)
#
#
# def solution(nums):
#     answer = 0
#     temp = list(itertools.permutations(nums, len(nums) // 2))
#     for idx in temp:
#         num = get(idx)
#         if num > answer:
#             answer = num
#     return answer
def solution(nums):
    lists = list(set(nums))
    limits = len(nums) // 2
    return limits if limits < len(lists) else len(limits)
a = solution([3,3,3,2,2,4])
print(a)