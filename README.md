# 📝 Table of Contents

# 알고리즘

- [알고리즘](#알고리즘)
- [시간복잡도](#시간복잡도)
- [삽입 정렬(Insertion Sort)](#삽입-정렬)
- [합병(머지,병합) 정렬(Merge Sort)](#합병-정렬)
- [버블(거품) 정렬(Bubble Sort)](#버블-정렬)
- [선택 정렬(Selection Sort)](#선택-정렬)
- [퀵 정렬(Quick Sort)](#퀵-정렬)
- [계수 정렬(Counting Sort)](#계수-정렬)
- [기수 정렬(Radix Sort)](#기수-정렬)

# 자료구조

- [연결리스트(LinkedList)](#연결리스트)
- [스택(Stack)](#스택)
- [큐(Queue)](#큐)
- [트리(Tree)](#트리)
- [힙(Heap)](#힙)
- [트리(Tree)](#트리)
- [AVL 트리(Tree)](#AVL-트리)
- [그래프(Graph)](#그래프)

---

## 알고리즘

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/57e22a778d6bcf0015231c8b)
  [Top](#📝-Table-of-Contents)

---

## 시간복잡도

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/57ea2987fdea850015313534)<br>
  [Top](#Table-of-Contents)

---

## 삽입 정렬

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/57e39fca76a7850015e6944a)
- 성능 : O(n^2)
- i : 뽑을 숫자의 위치를 선택할 변수
- temp : 뽑은 숫자 값을 저장할 변수
- j : 뽑은 숫자를 알맞은 위치에 넣을 때 사용할 변수

```javascript
var insertionSort = function (array) {
  var i = 1,
    j,
    temp;
  for (i; i < array.length; i++) {
    temp = array[i]; // 새로운 숫자를 선택한다.
    for (j = i - 1; j >= 0 && temp < array[j]; j--) {
      // 선택한 숫자를 이미 정렬된 숫자들과 비교하며 넣을 위치를 찾는 과정, 선택한 숫자가 정렬된 숫자보다 작으면
      array[j + 1] = array[j]; // 한 칸씩 뒤로 밀어낸다.
    }
    array[j + 1] = temp; // 마지막 빈 칸에 선택한 숫자를 넣어준다.
  }
  return array;
};

insertionSort([5, 6, 1, 2, 4, 3]); // [1, 2, 3, 4, 5, 6]
```

[Top](#Table-of-Contents)

---

## 합병 정렬

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/57ee1fc107c0b40015045cb4)
- 성능 : O(NlogN)
- mergeSort : 재귀를 하는 부분
- merge : 두 수끼리 비교하는 부분

```javascript
var mergeSort = function (array) {
  if (array.length < 2) return array; // 원소가 하나일 때는 그대로 내보냅니다.
  var pivot = Math.floor(array.length / 2); // 대략 반으로 쪼개는 코드
  var left = array.slice(0, pivot); // 쪼갠 왼쪽
  var right = array.slice(pivot, array.length); // 쪼갠 오른쪽
  return merge(mergeSort(left), mergeSort(right)); // 재귀적으로 쪼개고 합칩니다.
};
function merge(left, right) {
  var result = [];
  while (left.length && right.length) {
    if (left[0] <= right[0]) {
      // 두 배열의 첫 원소를 비교하여
      result.push(left.shift()); // 더 작은 수를 결과에 넣어줍니다.
    } else {
      result.push(right.shift()); // 오른쪽도 마찬가지
    }
  }
  while (left.length) result.push(left.shift()); // 어느 한 배열이 더 많이 남았다면 나머지를 다 넣어줍니다.
  while (right.length) result.push(right.shift()); // 오른쪽도 마찬가지
  return result;
}

mergeSort([5, 2, 4, 7, 6, 1, 3, 8]); // [1, 2, 3, 4, 5, 6, 7, 8]
```

[Top](#Table-of-Contents)

---

## 버블 정렬

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/57f67519799d150015511c38)
- 성능 : O(n^2)

```javascript
var bubbleSort = function (array) {
  var length = array.length;
  var i, j, temp;
  for (i = 0; i < length - 1; i++) {
    // 순차적으로 비교하기 위한 반복문
    for (j = 0; j < length - 1; j++) {
      // 끝까지 돌았을 때 다시 처음부터 비교하기 위한 반복문
      if (array[j] > array[j + 1]) {
        // 두 수를 비교하여 앞 수가 뒷 수보다 크면
        temp = array[j]; // 두 수를 서로 바꿔준다. array[j]의 값을
        array[j] = array[j + 1];
        array[j + 1] = temp; // array[j + 1]로 보낸다.
      }
    }
  }
  return array;
};

bubbleSort([5, 1, 7, 4, 6, 3, 2, 8]);
```

[Top](#Table-of-Contents)

---

## 선택 정렬

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/57f728c85141fc5fe4f4ca89)
- 성능 : O(n^2)

```javascript
var selectionSort = function (array) {
  var length = array.length;
  var minIndex, temp, i, j;
  for (i = 0; i < length - 1; i++) {
    // 처음부터 훑으면서
    minIndex = i;
    for (j = i + 1; j < length; j++) {
      // 최솟값의 위치를 찾는다.
      if (array[j] < array[minIndex]) {
        minIndex = j;
      }
    }
    temp = array[minIndex]; // 최솟값을 저장하고
    array[minIndex] = array[i];
    array[i] = temp; // 최솟값을 제일 앞으로 보낸다.
  }
  return array;
};

selectionSort([5, 1, 4, 7, 2, 6, 8, 3]); // [1,2,3,4,5,6,7,8]
```

[Top](#Table-of-Contents)

---

## 퀵 정렬

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/57f72d415141fc5fe4f4ca8b)
- 성능 : O(NlogN)
- 정렬하는 부분
- 재귀하는 부분

```javascript
var partition = function (array, left, right, pivotIndex) {
  // 정렬하는 부분
  var temp;
  var pivot = array[pivotIndex];
  while (left <= right) {
    // 왼쪽, 오른쪽 수를 규칙과 비교해 다음 수로 넘어갑니다.
    while (array[left] < pivot) left++;
    while (array[right] > pivot) right--;
    if (left <= right) {
      // 왼쪽이 기준보다 크고, 오른쪽이 기준보다 작으면
      temp = array[left];
      array[left] = array[right];
      array[right] = temp; // 서로 바꿔줍니다.
      left++;
      right--;
    }
  }
  temp = array[left];
  array[left] = array[pivotIndex];
  array[pivotIndex] = temp; // 마지막으로 기준과 만난 수를 바꾸꿔줍니다. 기준의 위치는 이제 i입니다.
  return left;
};

var quickSort = function (array, left, right) {
  // 재귀하는 부분
  if (!left) left = 0;
  if (!right) right = array.length - 1;
  var pivotIndex = right; // 배열 가장 오른쪽의 수를 기준으로 뽑습니다.
  pivotIndex = partition(array, left, right - 1, pivotIndex); // right -1 을 하는 이유는 기준 (현재 right)을 제외하고 정렬하기 위함입니다.
  if (left < pivotIndex - 1) quickSort(array, left, pivotIndex - 1); // 기준 왼쪽 부분 재귀
  if (pivotIndex + 1 < right) quickSort(array, pivotIndex + 1, right); // 기준 오른쪽 부분 재귀
  return array;
};

quickSort([4, 1, 7, 6, 3, 8, 2, 5]); // [1,2,3,4,5,6,7,8]
```

[Top](#Table-of-Contents)

---

## 계수 정렬

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/58006da88475ed00152d6c4b)
- 성능 : O(n + k)
- array
- [개수를 저장할 공간]
- [결과]

```javascript
var countingSort = function (array, k) {
  var count = [],
    result = [];
  for (var i = 0; i <= k; i++) {
    // 모든 숫자의 개수를 일단 0으로 초기화합니다.
    count[i] = 0;
  }
  console.log(count, result, array.length);
  for (var j = 0; j < array.length; j++) {
    // 숫자의 개수를 세어 저장합니다.
    count[array[j]] += 1;
  }
  console.log(count, result, k);
  for (i = 0; i < k; i++) {
    // 누적합을 구합니다.
    count[i + 1] += count[i];
  }
  console.log(count, result);
  for (j = 0; j < array.length; j++) {
    // 누적합이 가리키는 인덱스를 바탕으로 결과에 숫자를 집어넣습니다.
    console.log(array[j], count[array[j]] - 1);
    result[count[array[j]] - 1] = array[j];
    count[array[j]] -= 1;
  }
  console.log(count, result);
  return result;
};

// 배열에 큰 수가 들어갈 수록 메모리를 많이 잡아먹기 때문에 좋지 않습니다.
countingSort([3, 4, 0, 1, 2, 4, 2, 4], 4); // [0,1,2,2,3,4,4,4]
```

[Top](#Table-of-Contents)

---

## 기수 정렬

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/58007c338475ed00152d6c4c)
- O(dn)

```javascript
var counter = [[]];
var radixLSD = function (array, d) {
  var mod = 10;
  for (var i = 0; i < d; i++, mod *= 10) {
    // mod는 현재 정렬 중인 자리수를 나타내는 것으로 10부터 해서 100, 1000, ...으로 커집니다.
    for (var j = 0; j < array.length; j++) {
      var bucket = parseInt(array[j] % mod); // 같은 그룹으로 묶일 나머지를 나타내는 부분입니다.
      if (counter[bucket] == null) {
        counter[bucket] = [];
      }
      counter[bucket].push(array[j]); // 나머지 별로 묶어줍니다.
      console.log("bucket", bucket, counter[bucket]);
    }
    console.log(counter.slice(0));
    var pos = 0;
    for (var j = 0; j < counter.length; j++) {
      // counter에 저장한 묶음들(나머지 순서로 정렬됨)을 실제 배열에 반영해줍니다.
      var value = null;
      if (counter[j] != null) {
        while ((value = counter[j].shift()) != null) {
          array[pos++] = value;
        }
      }
    }
    console.log(array);
  }
  return array;
};
radixLSD([125, 383, 274, 96, 0, 9, 81, 72], 3); // [0,9,72,81,96,125,274,383]
```

[Top](#Table-of-Contents)

---

## 연결리스트

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/58008a628475ed00152d6c4d)
- length : 노드의 개수를 표현하는 부분, head : 첫 노드의 주소를 가리키는 부분
- data, next
- add, search, remove

```javascript
var LinkedList = (function () {
  function LinkedList() {
    this.length = 0;
    this.head = null;
  }
  function Node(data) {
    this.data = data;
    this.next = null;
  }
  LinkedList.prototype.add = function (value) {
    var node = new Node(value);
    var current = this.head;
    if (!current) {
      // 현재 아무도 없으면
      this.head = node; // head에 새 노드를 추가합니다.
      this.length++;
      return node;
    } else {
      // 이미 노드가 있다면
      while (current.next) {
        // 마지막 노드를 찾고
        current = current.next;
      }
      current.next = node; // 마지막 위치에 노드를 추가합니다.
      this.length++;
      return node;
    }
  };
  LinkedList.prototype.search = function (position) {
    var current = this.head;
    var count = 0;
    while (count < position) {
      // position 위치만큼 이동합니다.
      current = current.next;
      count++;
    }
    return current.data;
  };
  LinkedList.prototype.remove = function (position) {
    var current = this.head;
    var before;
    var remove;
    var count = 0;
    if (position == 0) {
      // 맨 처음 노드를 삭제하면
      remove = this.head;
      this.head = this.head.next; // head를 두 번째 노드로 교체
      this.length--;
      return remove;
    } else {
      // 그 외의 다른 노드를 삭제하면
      while (count < position) {
        before = current;
        count++;
        current = current.next;
      }
      remove = current;
      before.next = remove.next;
      // remove 메모리 정리
      this.length--;
      return remove;
    }
  };
  return LinkedList;
})();

var list = new LinkedList();
list.add(1);
list.add(2);
list.add(3);
list.length; // 3
list.search(0); // 1
list.search(2); // 3
list.remove(1);
list.length; // 2
```

[Top](#Table-of-Contents)

---

## 스택

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/5800b79e1dfb250015c38db6)
- top, count
- data, next
- push, pop, stackTop

```javascript
var Stack = (function () {
  function Stack() {
    this.top = null;
    this.count = 0;
  }
  function Node(data) {
    this.data = data;
    this.next = null;
  }
  Stack.prototype.push = function (data) {
    var node = new Node(data);
    node.next = this.top;
    this.top = node;
    return ++this.count;
  };
  Stack.prototype.pop = function () {
    if (!this.top) {
      // stack underflow 방지
      return false;
    }
    var data = this.top.data;
    this.top = this.top.next;
    // 예전 this.top의 메모리 정리
    this.count--;
    return data;
  };
  Stack.prototype.stackTop = function () {
    return this.top.data;
  };
  return Stack;
})();

var stack = new Stack();
stack.push(1); // 1
stack.push(3); // 2
stack.push(5); // 3
stack.pop(); // 5
stack.stackTop(); // 3
```

[Top](#Table-of-Contents)

---

## 큐

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/580b9b94108f510015524097)
- count, head, rear
- data, next
- enqueue, dequeue, front

```javascript
var Queue = (function () {
  function Queue() {
    this.count = 0;
    this.head = null;
    this.rear = null;
  }
  function Node(data) {
    this.data = data;
    this.next = null;
  }
  Queue.prototype.enqueue = function (data) {
    var node = new Node(data);
    if (!this.head) {
      this.head = node;
    } else {
      this.rear.next = node;
    }
    this.rear = node;
    return ++this.count;
  };
  Queue.prototype.dequeue = function () {
    if (!this.head) {
      // stack underflow 방지
      return false;
    }
    var data = this.head.data;
    this.head = this.head.next;
    // this.head 메모리 클린
    --this.count;
    return data;
  };
  Queue.prototype.front = function () {
    return this.head && this.head.data;
  };
  return Queue;
})();

var queue = new Queue();
queue.enqueue(1); // 1
queue.enqueue(3); // 2
queue.enqueue(5); // 3
queue.dequeue(); // 1
queue.front(); // 3
```

[Top](#Table-of-Contents)

---

## 트리

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/580ed6eb77023c0015ee9686)
- Tree(count, root)
- Node(data, left, right)
- add, get, remove

```javascript
var Tree = (function () {
  function Tree() {
    this.count = 0;
    this.root;
  }
  function Node(data) {
    this.data = data;
    this.left;
    this.right;
  }
  function _insert(root, node) {
    if (!root) return node;
    if (node.data < root.data) {
      root.left = _insert(root.left, node);
      return root;
    } else {
      root.right = _insert(root.right, node);
      return root;
    }
    return root;
  }
  Tree.prototype.add = function (data) {
    var node = new Node(data);
    if (this.count == 0) {
      this.root = node;
    } else {
      _insert(this.root, node);
    }
    return ++this.count;
  };
  function _get(data, node) {
    if (node) {
      if (data < node.data) {
        return _get(data, node.left);
      } else if (data > node.data) {
        return _get(data, node.right);
      } else {
        return node;
      }
    } else {
      return null;
    }
  }
  Tree.prototype.get = function (data) {
    if (this.root) {
      return _get(data, this.root);
    } else {
      return null;
    }
  };
  function _remove(root, data) {
    var newRoot, exchange, temp;
    if (!root) return false;
    if (data < root.data) {
      root.left = _remove(root.left, data);
    } else if (data > root.data) {
      root.right = _remove(root.right, data);
    } else {
      if (!root.left) {
        newRoot = root.right;
        // root 메모리 정리
        return newRoot;
      } else if (!root.right) {
        newRoot = root.left;
        // root 메모리 정리
        return newRoot;
      } else {
        exchange = root.left;
        while (exchange.right) exchange = exchange.right;
        temp = root.data;
        root.data = exchange.data;
        exchange.data = temp;
        root.left = _remove(root.left, exchange.data);
      }
    }
    return root;
  }
  Tree.prototype.remove = function (key) {
    var node = _remove(this.root, key);
    if (node) {
      this.root = node;
      this.count--;
      if (this.count == 0) this.root = null;
    }
    return true;
  };
  return Tree;
})();

var tree = new Tree();
tree.add(5); // 1
tree.add(3); // 2
tree.add(4); // 3
tree.add(2); // 4
tree.add(7); // 5
tree.add(6); // 6
tree.root.left.data; // 3
tree.root.left.left.data; // 2;
tree.root.left.right.data; // 4
tree;
tree.remove(3);
tree.root.left.data;
```

[Top](#Table-of-Contents)

---

## 힙

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/582de223d4416a001860e763)

```javascript
```

[Top](#Table-of-Contents)

---

## AVL 트리

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/583cacb648a7340018ac73f1)

```javascript
```

[Top](#Table-of-Contents)

---

## 그래프

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/584b9033580277001862f16c)

```javascript
```

[Top](#Table-of-Contents)

---
