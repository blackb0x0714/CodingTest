# Queue

- 출처 : 위니브즈와 함께하는 벼락치기 코딩 (https://www.notion.so/a5a0fafe306e4cb78ec4476a272d156d?v=e116f6cdc6e34075bf8e4c0e56429a26)

---

## 큐의 정의

- 컴퓨터의 기본적인 자료 구조의 한가지, **Python**은 **insert(0, 값)**와 **pop(0)**로 구현할 수 있으며, **Javascript**는 **unshift**와 **shift**로 구현할 수 있음.
- 먼저 집어 넣은 데이터가 먼저 나오는 선입선출(FIFO - Frist In First Out)구조로 저장하는 형식
- 프린터의 출력 처리나 윈도우 시스템의 메시지 처리기, 프로세스 관리 등 데이터가 입력된 시간 순서대로 처리해야 할 필요가 있는 상황에 이용

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1aaa78a3-1000-415b-b622-0c3f89b86858/_13.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1aaa78a3-1000-415b-b622-0c3f89b86858/_13.png)

---

## 큐의 용어

- put : 큐에 자료를 넣는 것
- get : 큐에서 자료를 꺼내는 것
- front : 데이터를 get할 수 있는 위치
- rear : 데이터를 put할 수 있는 위치
- Overflow : 큐가 꽉 차서 더 이상 자료를 넣을 수 없는 경우
- Underflow : 큐가 비어 있어 자료를 꺼낼 수 없는 경우

---

## 큐의 종류

### 1. 선형 큐

- 막대 모양으로 된 큐
- 크기가 제한되어 있고 빈 공간을 사용하려면 모든 자료를 꺼내거나 자료를 한 칸씩 옮겨야

  한다는 단점이 있음

- Data : A → B → C → D

             - insert

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d6c677a5-1ac4-4295-92b3-e14c07264708/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d6c677a5-1ac4-4295-92b3-e14c07264708/Untitled.png)

### 2. 환형 큐

- 배열로 큐를 선언할 시 큐의 삭제와 생성이 계속 일어났을때, 마지막 배열에 도달후 실제로는 데이터공간이 남아있지만 오버플로우가 발생하는 선형 큐의 문제점을 보완한 것
- front(head)가 큐의 끝에 닿으면 큐의 맨 앞으로 자료를 보내어 원형으로 연결
- Data : A → B → C → D → E

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/229b5632-70e1-422e-a53f-784ac7bf960b/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/229b5632-70e1-422e-a53f-784ac7bf960b/Untitled.png)

출처 : [https://ko.wikipedia.org/wiki/큐*(자료*구조](<https://ko.wikipedia.org/wiki/%ED%81%90_(%EC%9E%90%EB%A3%8C_%EA%B5%AC%EC%A1%B0)>)) (위키백과)
