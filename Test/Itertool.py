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
wants = [101, 103, 105]
for want in range(0, len(wants)):
    SELECT(wants[want])
    STACK()
    rBind()
