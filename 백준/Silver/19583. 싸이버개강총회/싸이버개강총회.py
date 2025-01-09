S, E, Q = map(str, input().split())

def change_time(time):
    h, m = map(int, time.split(':'))
    return h * 60 + m

S = change_time(S)
E = change_time(E)
Q = change_time(Q)

attend = set()
ans = 0

while True:
    try:
        time, name = input().split()
        time = change_time(time)
        if time <= S:
            attend.add(name)
            # print(f"check before name : ", name)
        elif E <= time <= Q and name in attend:
            # print(f"check after name : ", name)
            attend.remove(name)
            ans += 1
    except:
        break

print(ans)