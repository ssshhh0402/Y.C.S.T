def solution(nums):
    answer = 0
    def pn(number):
        count = 0
        for num in range(1, number+1):
            if not number % num:
                count += 1
        if count == 2:
            return True
        else:
            return False

    def find(nums, num, base):
        if len(base) == 3:
            if pn(sum(base)):
                return 1
            else:
                return 0

        count = 0
        for idx in range(num+1, len(nums)):
            base.append(nums[idx])
            count += find(nums,idx,base)
            base.pop()
        return count

    for num in range(len(nums)):
        answer += find(nums, num, [nums[num]])
    return answer


print(solution([1,2,3,4]))
print(solution([1,2,7,6,4]))