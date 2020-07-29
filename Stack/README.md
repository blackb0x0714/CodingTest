# Stack

- 출처 : 위니브즈와 함께하는 벼락치기 코딩 (https://www.notion.so/a5a0fafe306e4cb78ec4476a272d156d?v=e116f6cdc6e34075bf8e4c0e56429a26)

---

## 스택의 정의

- **스택**(stack)은 목록 끝에서만 데이터가 들어오고 나가는 자료구조이다. 사진을 참고하면 좀 더 쉽게 이해할 수 있다. **Python**으로 구현 할 때에는 **list**의 **append**와 **pop**을 이용하여 구현할 수 있으며, **Javascript**에서는 **Array**에 **push**와 **pop**을 이용하여 구현할 수 있다.
- 스택은 한 쪽 끝에서만 자료를 넣거나 뺄 수 있는 선형 구조(LIFO - Last In First Out)으로 되어 있다. 자료를 넣는 것을 '밀어넣는다' 하여 **푸쉬**(push)라고 하고 반대로 넣어둔 자료를 꺼내는 것을 **팝**(pop)이라고 하는데, 이때 꺼내지는 자료는 가장 최근에 푸쉬한 자료부터 나오게 된다.
  이처럼 나중에 넣은 값이 먼저 나오는 것을 [LIFO](https://ko.wikipedia.org/wiki/LIFO) 구조라고 한다.
- 스택이 비었다면 1을 반환하고,그렇지 않다면 0을 반환한다.

---

## 스택의 연산

여기서 사용하는 메서드의 명은 wiki 출처를 따릅니다. 실제 구현되어 있는 언어별 메서드와는 다른 개념, 즉 자료구조의 개념이다.

- top() : 스택의 가장 윗(마지막) 데이터를 반환한다.
- pop() : 스택의 가장 윗(마지막) 데이터를 삭제한다
- push() : 스택의 가장 윗 데이터로 top이 가리키는 자리 위에(top = top + 1) 메모리를 생성,

  데이터 x를 넣는다.

- is_empty() : 스택이 비었다면 True 를 반환하고,그렇지 않다면 False 를 반환한다.

  출처 : [https://ko.wikipedia.org/wiki/스택](https://ko.wikipedia.org/wiki/%EC%8A%A4%ED%83%9D)

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
stack.push(3);
console.log(stack.pop()); //3
console.log("stack", stack); //[1, 2]
```
