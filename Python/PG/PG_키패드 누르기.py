def solution(numbers, hand):
    answer = ''
    keypad = [[3,1], [0, 0], [0, 1], [0, 2], [1, 0], [1, 1], [1, 2], [2, 0], [2, 1], [2, 2]]
    left_number = [3,0]
    right_number = [3,2]
    for number in numbers:
        if number % 3 == 1:
            answer += 'L'
            left_number = keypad[number]
        elif number % 3 == 0 and number != 0:
            answer += 'R'
            right_number = keypad[number]
        else:
            d_left = abs(left_number[0] - keypad[number][0]) + abs(left_number[1] - keypad[number][1])
            d_right = abs(right_number[0] - keypad[number][0]) + abs(right_number[1] - keypad[number][1])
            if d_right > d_left:
                answer += 'L'
                left_number = keypad[number]
            elif d_left > d_right:
                answer += 'R'
                right_number = keypad[number]
            else:
                if hand == "left":
                    answer += 'L'
                    left_number = keypad[number]
                else:
                    answer += 'R'
                    right_number = keypad[number]
    return answer

# print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"))
# print(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left"))
print(solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 0], "right"))