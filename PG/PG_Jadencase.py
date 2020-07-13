def solution(s):
    answer = ''
    s = s.split(" ")
    for words in s:
        for word in range(len(words)):
            if word == 0 :
                answer += words[word].upper()
            else:
                answer += words[word].lower()
        answer += " "
    return answer[0:-1]


print(solution("3people Unfollow Me"))