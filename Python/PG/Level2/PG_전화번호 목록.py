def solution(phone_book):
    # phone_book.sort()
    # for phone in range(len(phone_book) - 1):
    #     if phone_book[phone + 1].startswith(phone_book[phone]):
    #         return False
    # return True

    phone_book.sort()
    for phone_1, phone_2 in zip(phone_book, phone_book[1:]):
        if phone_2.startswith(phone_1):
            return False
    return True
    

print(solution(["119","23456", "97674223", "1195524421"]))
