def process_weeks(N, A, B, M):
    # 초기 방 순서와 점수 초기화
    seq = list(range(1, N + 1))  # 방 번호 순서
    points = [0] * (N + 1)  # 점수 배열

    good_weeks = 0
    current_consecutive_good = 0
    max_consecutive_good = 0

    for week in range(1, M + 1):
        # 마지막 주에는 점수 입력을 받지 않음
        if week != M:
            merits = list(map(int, input().split()))
            demerits = list(map(int, input().split()))
            for i in range(1, N + 1):
                points[i] = merits[i - 1] - demerits[i - 1]

        # 홍 군과 조 군 위치 확인
        Hong_pos = seq.index(1) + 1  # 방 번호는 1부터 시작하므로 +1
        Jo_pos = seq.index(A) + 1

        # 기분 좋은 주인지 확인
        if abs(Hong_pos - Jo_pos) <= B:
            good_weeks += 1
            current_consecutive_good += 1
            max_consecutive_good = max(max_consecutive_good, current_consecutive_good)
        else:
            current_consecutive_good = 0

        # 방 교환 로직
        for i in range(N - 1):
            prev = points[seq[i]]
            sub = points[seq[i + 1]]

            if should_swap(prev, sub):
                # 방 교환
                seq[i], seq[i + 1] = seq[i + 1], seq[i]
                # 점수 교환
                points[seq[i]], points[seq[i + 1]] = sub - 2, prev + 2

    return good_weeks, max_consecutive_good


def should_swap(prev, sub):
    # Java의 조건과 동일하게 교환 조건 정의
    if (prev >= 0 and sub >= 0 and sub - prev >= 2) or \
       (prev < 0 and sub < 0 and sub - prev >= 4) or \
       (sub >= 0 and prev < 0):
        return True
    return False


# 입력 처리
N, A, B, M = map(int, input().split())

# 결과 계산 및 출력
good_weeks, max_good_streak = process_weeks(N, A, B, M)
print(good_weeks, max_good_streak)
