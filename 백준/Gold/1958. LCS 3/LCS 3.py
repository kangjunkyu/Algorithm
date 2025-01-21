s1 = input()
s2 = input()
s3 = input()

s1_len = len(s1)
s2_len = len(s2)
s3_len = len(s3)

arr = [[[0] * (s3_len + 1) for _ in range(s2_len + 1)] for _ in range(s1_len + 1)]

for i in range(1, s1_len + 1):
    for j in range(1, s2_len + 1):
        for k in range(1, s3_len + 1):
            if s1[i - 1] == s2[j - 1] == s3[k - 1]:
                arr[i][j][k] = arr[i - 1][j - 1][k - 1] + 1
            else:
                arr[i][j][k] = max(arr[i - 1][j][k], arr[i][j - 1][k], arr[i][j][k - 1])

print(arr[s1_len][s2_len][s3_len])