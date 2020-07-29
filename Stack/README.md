# Stack

- 출처 : [위니브즈와 함께하는 벼락치기 코딩](https://www.notion.so/a5a0fafe306e4cb78ec4476a272d156d?v=e116f6cdc6e34075bf8e4c0e56429a26)

- 출처 : [Cookie님 Velog](https://velog.io/@ryu/JavaScript-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-Array%EB%B0%B0%EC%97%B4)

---

## 스택의 정의

- **스택**(stack)은 목록 끝에서만 데이터가 들어오고 나가는 자료구조이다.<br>
  사진을 참고하면 좀 더 쉽게 이해할 수 있다.<br>
  **Python**으로 구현 할 때에는 list의 `append`와 `pop`을 이용하여 구현할 수 있으며,<br>
  **Javascript**에서는 Array에 `push`와 pop을 이용하여 구현할 수 있다.<br>
- 스택은 한 쪽 끝에서만 자료를 넣거나 뺄 수 있는 선형 구조(LIFO - Last In First Out)으로 되어 있다.<br>
  자료를 넣는 것을 '밀어넣는다' 하여 **푸쉬(push)**라고 하고,<br> 반대로 넣어둔 자료를 꺼내는 것을 **팝(pop)**이라고 하는데,<br>
  이때 꺼내지는 자료는 가장 최근에 푸쉬한 자료부터 나오게 된다.<br>
  이처럼 나중에 넣은 값이 먼저 나오는 것을 [LIFO](https://ko.wikipedia.org/wiki/LIFO) 구조라고 한다.<br>
- 스택이 비었다면 1을 반환하고, 그렇지 않다면 0을 반환한다.

---

## 스택의 연산

여기서 사용하는 메서드의 명은 wiki 출처를 따릅니다.<br>
실제 구현되어 있는 언어별 메서드와는 다른 개념, 즉 자료구조의 개념이다.

- top() : 스택의 가장 윗(마지막) 데이터를 반환한다.
- pop() : 스택의 가장 윗(마지막) 데이터를 삭제한다
- push() : 스택의 가장 윗 데이터로 top이 가리키는 자리 위에(top = top + 1)<br>
  메모리를 생성, 데이터 x를 넣는다.
- is_empty() : 스택이 비었다면 True(1) 를 반환하고, 그렇지 않다면 False(0)를 반환한다.

- 출처 : [위키백과](https://ko.wikipedia.org/wiki/%EC%8A%A4%ED%83%9D)

---

## Stack 구현하기 (ES6)

- 큐와 마찬가지로 Array 를 사용하여 Stack 을 구현할 수 있습니다.
- Array의 `push()`, `pop()` 메소드를 사용합니다.

```javascript
class Stack {
  constructor() {
    this.arr = [];
  }

  push(x) {
    this.arr.push(x);
  }

  pop() {
    return this.arr.pop();
  }

  empty() {
    if (this.arr.length === 0) {
      return 1;
    } else {
      return 0;
    }
  }
}

const stack = new Stack();
stack.push(1);
stack.push(2);
stack.pop(); // 2
console.log("stack", stack); // [1]
```

---

## Queue 2개로 Stack 구현하기

1. Main Queue 와 Sub Queue 두개를 둔다.
2. Main Queue 가 비었을 때는 item 을 바로 enqueue 하고,<br>
   그렇지 않을 때는 Main Queue 의 요소들을 Sub Queue 로 모두 옮겨서 비운 다음에<br>
   item 을 enqueue 한다. 이후 Sub 에 있는 요소들을 다시 Main 으로 옮긴다.

```javascript
class Queue {
  constructor() {
    this.store = [];
  }

  enqueue(item) {
    this.store.push(item);
  }

  dequeue() {
    return this.store.shift();
  }

  empty() {
    return this.store.length === 0;
  }
}

class Stack {
  constructor() {
    this.main = new Queue();
    this.sub = new Queue();
  }

  push(item) {
    if (this.main.empty()) {
      this.main.enqueue(item);
    } else {
      while (!this.main.empty()) {
        this.sub.enqueue(this.main.dequeue());
      }
      this.main.enqueue(item);
      while (!this.sub.empty()) {
        this.main.enqueue(this.sub.dequeue());
      }
    }
  }

  pop() {
    this.main.dequeue();
  }
}

const stack = new Stack();
stack.push(1);
stack.push(2);
stack.push(3);
stack.pop();
console.log(stack.main.store); // [2, 1]
```

## Stack 2개로 Stack 구현하기

1. 데이터를 쌓을 스택 InStack, 데이터를 추출할 스택 OutStack 을 만듭니다.<br>enqueue 액션이 발생하면, InStack 에 데이터를 쌓습니다.
2. dequeue 액션이 발생하면, OutStack 에 있는 요소를 반환합니다.
3. 이때, OutStack 이 비어 있다면, InStack 의 요소들을 OutStack 으로 모두 옮긴 다음, OutStack 에서 하나를 추출해서 반환합니다.

```javascript
class Stack {
  constructor() {
    this.store = [];
  }

  push(item) {
    this.store.push(item);
  }

  pop() {
    return this.store.pop();
  }
}

class Queue {
  constructor() {
    this.inStack = new Stack();
    this.outStack = new Stack();
  }

  enqueue(item) {
    this.inStack.push(item);
  }

  dequeue() {
    if (this.outStack.store.length === 0) {
      while (this.inStack.store.length > 0) {
        this.outStack.push(this.inStack.pop());
      }
    }
    return this.outStack.pop();
  }
}

const queue = new Queue();
queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);

queue.dequeue(); // 1
```
