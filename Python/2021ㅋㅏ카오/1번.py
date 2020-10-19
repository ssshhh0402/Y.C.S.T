def solution(new_id):
    new_id = list(word.lower() if word.isalpha() else word for word in new_id)
    new_id = ''.join(list(word if word.isalpha() or word.isdigit() or word =='-' or word == '_' or word == '.' else '' for word in new_id))
    while ".." in new_id:
        new_id = new_id.replace("..", ".")
    while new_id:
        if new_id[0] == '.':
            new_id = new_id[1:]
            continue
        if new_id[-1] == '.':
            new_id = new_id[:-1]
            continue
        break

    if not new_id:
        new_id = 'a'
    if len(new_id) >= 16:
        new_id = new_id[:15]
    if new_id[-1] == '.':
        new_id = new_id[:-1]
    if len(new_id) <= 2:
        n = len(new_id)
        new_id += new_id[-1] * (3-n)

    return new_id

#print(solution("...!@BaT#*..y.abcdefghijklm"))
print(solution("=.="))