import sys
input = sys.stdin.readline
n = int(input())
total = {}
for _ in range(n):
    useTime,student = input().split()
    h,m = map(int,useTime.split(':'))
    total[student] = total.get(student,0) + 60*h + m
ls = list()
for student in total:
    exceedTime = max(total[student] - 100,0)
    totalPay = 10 + 3*(exceedTime//50)
    if exceedTime%50:
        totalPay += 3
    ls.append((student,totalPay))
ls.sort(key=lambda x:(-x[1],x[0]))
for student,payment in ls:
    print(student,payment)