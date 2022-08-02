def solution(N, stages):
    answer = []
    for i in range(1,N+1):
        count=0 #나눌수
        if stages.count(i) != 0:  #스테이지에 도달했으나아직 클리어 하지 못한 플레이어의 수가 하나라도 있으면
            for j in  range(len(stages)):  #스테이지에 도달한 플레이어의 수 구하기
                if stages[j]>=i:
                    count+=1
            answer.append((i,stages.count(i)/count))
        else:    #스테이지에 도달했으나아직 클리어 하지 못한 플레이어의 수가 하나도 없으면
            answer.append((i,0))  #실패율을 0으로 하고 추가

    answer=sorted(answer,key=lambda x:(-x[1],x[0]))   #실패율은 내림차순으로 하고 실패율이 같으면 스테이지 번호는 올림차순으로 하기

    an=[] #스테이지의 번호만 리스트로 만들기
    for k in range(len(answer)):
        an.append(answer[k][0])
    return an

n=int(input())
list=list(map(int,input().split()))
print(solution(n,list))