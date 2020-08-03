# 📝 Table of Contents

# 알고리즘

- [알고리즘이란](#알고리즘이란)
- [시간복잡도](#시간복잡도)
- [삽입 정렬(Insertion Sort)](#삽입-정렬)
- [합병(머지,병합) 정렬(Merge Sort)](#합병-정렬)
- [버블(거품) 정렬(Bubble Sort)](#버블-정렬)
- [선택 정렬(Selection Sort)](#선택-정렬)
- [퀵 정렬(Quick Sort)](#퀵-정렬)
- [계수 정렬(Counting Sort)](#계수-정렬)
- [기수 정렬(Radix Sort)](#기수-정렬)
- [동적 프로그래밍(Dynamic programming)](#동적-프로그래밍)
- [탐욕(그리디) 알고리즘(greedy algorithm)](#탐욕-알고리즘)
- [최소 신장 트리(MST, minimum spanning tree)](#최소-신장-트리)
- [최단 경로 알고리즘](#최단-경로-알고리즘)
- [그래프 탐색](#그래프-탐색)
- [네트워크 플로우(network flow)](#네트워크-플로우)
  <br>
- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm?page=3)

# 자료구조

- [연결리스트(LinkedList)](#연결리스트)
- [스택(Stack)](#스택)
- [큐(Queue)](#큐)
- [트리(Tree)](#트리)
- [힙(Heap)](#힙)
- [트리(Tree)](#트리)
- [AVL 트리(Tree)](#AVL-트리)
- [그래프(Graph)](#그래프)
- [해쉬(Hash)](#해쉬)
  <br>
- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm?page=2)

# 프로그래머스 문제풀이

- [Level-1](#Level-1)

---

## 알고리즘이란

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/57e22a778d6bcf0015231c8b)
  [Top](#알고리즘)

---

## 시간복잡도

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/57ea2987fdea850015313534)<br>
  [Top](#알고리즘)

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
    temp = array[i]; // 새로운 숫자를 선택함
    for (j = i - 1; j >= 0 && temp < array[j]; j--) {
      // 선택한 숫자를 이미 정렬된 숫자들과 비교하며 넣을 위치를 찾는 과정, 선택한 숫자가 정렬된 숫자보다 작으면
      array[j + 1] = array[j]; // 한 칸씩 뒤로 밀어낸다
    }
    array[j + 1] = temp; // 마지막 빈 칸에 선택한 숫자를 넣어준다.
  }
  return array;
};
insertionSort([5, 6, 1, 2, 4, 3]); // [1, 2, 3, 4, 5, 6]
```

[Top](#알고리즘)

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

[Top](#알고리즘)

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
    for (j = 0; j < length - 1 - i; j++) {
      // 끝까지 돌았을 때 다시 처음부터 비교하기 위한 반복문
      if (array[j] > array[j + 1]) {
        // 두 수를 비교하여 앞 수가 뒷 수보다 크면
        temp = array[j]; // 두 수를 서로 바꿔준다
        array[j] = array[j + 1];
        array[j + 1] = temp;
      }
    }
  }
  return array;
};

bubbleSort([5, 1, 7, 4, 6, 3, 2, 8]);
```

[Top](#알고리즘)

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

[Top](#알고리즘)

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
  array[pivotIndex] = temp; // 마지막으로 기준과 만난 수를 바꿔줍니다. 기준의 위치는 이제 i입니다.
  return left;
};

var quickSort = function (array, left, right) {
  // 재귀하는 부분
  if (!left) left = 0;
  if (!right) right = array.length - 1;
  var pivotIndex = right; // 배열 가장 오른쪽의 수를 기준으로 뽑습니다.
  pivotIndex = partition(array, left, right - 1, pivotIndex); // right - 1을 하는 이유는 기준(현재 right)을 제외하고 정렬하기 위함입니다.
  if (left < pivotIndex - 1) quickSort(array, left, pivotIndex - 1); // 기준 왼쪽 부분 재귀
  if (pivotIndex + 1 < right) quickSort(array, pivotIndex + 1, right); // 기준 오른쪽 부분 재귀
  return array;
};

quickSort([4, 1, 7, 6, 3, 8, 2, 5]); // [1,2,3,4,5,6,7,8]
```

[Top](#알고리즘)

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
    // 누적합이 가리키는 인덱스를 바탕으로 결과에 숫자를  집어넣습니다.
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

[Top](#알고리즘)

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

[Top](#알고리즘)

---

## 동적 프로그래밍

```javascript
```

[Top](#알고리즘)

---

## 탐욕 알고리즘

```javascript
```

[Top](#알고리즘)

---

## 최소 신장 트리

```javascript
```

[Top](#알고리즘)

---

## 최단 경로 알고리즘

```javascript
```

[Top](#알고리즘)

---

## 그래프 탐색

```javascript
```

[Top](#알고리즘)

---

## 네트워크 플로우

```javascript
```

[Top](#알고리즘)

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
      // 현재 아무 노드도 없으면
      this.head = node; // head에 새 노드를 추가합니다.
      this.length++;
      return node;
    } else {
      // 이미 노드가 있으면
      while (current.next) {
        // 마지막 노드를 찾고.
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

[Top](#알고리즘)

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

[Top](#알고리즘)

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

[Top](#알고리즘)

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

[Top](#알고리즘)

---

## 힙

- O(NlgN)

- 출처 : [Zero Cho님 사이트](hhttps://www.zerocho.com/category/Algorithm/post/582de223d4416a001860e763)

```javascript
var Heap = (function () {
  function Heap() {
    this.arr = [];
  }
  function reheapUp(self, idx) {
    if (idx) {
      var parent = parseInt((idx - 1) / 2);
      if (self.arr[idx] > self.arr[parent]) {
        var temp = self.arr[idx];
        self.arr[idx] = self.arr[parent];
        self.arr[parent] = temp;
        reheapUp(self, parent);
      }
    }
  }
  function reheapDown(self, idx) {
    var left = 0;
    var right = 0;
    var large;
    if (idx * 2 + 1 < self.arr.length) {
      left = self.arr[idx * 2 + 1];
      if (idx * 2 + 2 < self.arr.length - 1) {
        right = self.arr[idx * 2 + 2];
      }
      if (left > right) {
        large = idx * 2 + 1;
      } else {
        large = idx * 2 + 2;
      }
      if (self.arr[idx] < self.arr[large]) {
        var temp = self.arr[idx];
        self.arr[idx] = self.arr[large];
        self.arr[large] = temp;
        reheapDown(self, large);
      }
    }
  }
  Heap.prototype.insert = function (number) {
    var last = this.arr.length;
    this.arr[last] = number;
    reheapUp(this, last);
    return true;
  };
  Heap.prototype.delete = function () {
    if (this.arr.length === 0) {
      return false;
    }
    var del = this.arr[0];
    this.arr[0] = this.arr.pop();
    reheapDown(this, 0);
    return del;
  };
  Heap.prototype.sort = function () {
    var sort = [];
    var count = this.arr.length;
    for (var i = 0; i < count; i++) {
      sort.push(this.delete());
    }
    return sort;
  };
  return Heap;
})();

var heap = new Heap();
heap.insert(5);
heap.insert(3);
heap.insert(7);
heap.insert(4);
heap.insert(2);
heap.insert(6);
heap.insert(1);
heap.sort(); // [7,6,5,4,3,2,1]
```

[Top](#알고리즘)

---

## AVL 트리

- 정의부
- 삽입부
- 삭제부
- 실행부분

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/583cacb648a7340018ac73f1)

```javascript
// 1. 정의부
var AVL = (function () {
  function AVL() {
    this.count = 0;
    this.root;
    this.taller;
    this.shorter;
    this.success;
  }
  function Node(data) {
    this.data = data;
    this.left;
    this.right;
    this.bal = 0; // 왼쪽과 오른쪽의 차이를 저장
  }
  // 삽입부 코드를 여기에
  // 삭제부 코드를 여기에
  AVL.prototype.insert = function (data) {
    this.taller = false;
    var node = new Node(data);
    this.root = this._insert(this.root, node);
    this.count++;
  };

  AVL.prototype.delete = function (key) {
    this.shorter = false;
    this.succuess = false;
    var newRoot = this._delete(this.root, key);
    if (this.success) {
      this.root = newRoot;
      this.count--;
      return true;
    }
    return false;
  };

  AVL.prototype.search = function (key) {
    if (this.root) {
      return this._search(key, this.root);
    }
    return false;
  };

  AVL.prototype._search = function (key, root) {
    if (root) {
      if (key < root.data) {
        return this._search(key, root.left);
      } else if (key > root.data) {
        return this._search(key, root.right);
      } else {
        return root;
      }
    }
    return;
  };

  AVL.prototype._rotateLeft = function (root) {
    var temp = root.right; // temp를 중간 노드로 생각하면 이해하기 쉽다.
    root.right = temp.left;
    temp.left = root;
    return temp;
  };

  AVL.prototype._rotateRight = function (root) {
    var temp = root.left; // temp를 중간 노드로 생각하면 이해하기 쉽다.
    root.left = temp.right;
    temp.right = root;
    return temp;
  };

  return AVL;
})();

// 2. 삽입부
AVL.prototype._insert = function (root, node) {
  // 내부적 insert 메소드
  if (!root) {
    // 트리의 말단 부분에 도달하면 바로 넣는다.
    root = node;
    this.taller = true;
    console.log("no root", root);
    return root;
  }
  if (node.data < root.data) {
    // 새 값이 루트 값보다 작으면
    root.left = this._insert(root.left, node);
    console.log("go left", this.taller, root.bal);
    if (this.taller) {
      // 삽입으로 인해서 한 쪽이 더 길어졌으면
      switch (root.bal) {
        case 1: // 왼쪽이 더 긴 상태에서 또 왼쪽에 넣어줬으므로 LL 또는 RL
          root = this._insLeftBal(root);
          break;
        case 0: // 균형이었던 상태에서 왼쪽에 넣어줬으므로 왼쪽이 길어짐
          root.bal = 1;
          break;
        case -1: // 오른쪽이 길었던 상태에서 왼쪽에 넣어줬기 때문에 균형
          root.bal = 0;
          this.taller = false;
          break;
      }
    }
    return root;
  } else {
    // 새 값이 루트 값보다 크면
    root.right = this._insert(root.right, node);
    console.log("go right", this.taller, root.bal);
    if (this.taller) {
      // 삽입으로 인해서 한 쪽이 더 길어졌으면
      switch (root.bal) {
        case 1: // 왼쪽이 긴 상태에서 오른쪽에 넣어줬기 때문에 균형
          root.bal = 0;
          this.taller = false;
          break;
        case 0: // 균형이었던 상태에서 오른쪽에 넣어줬기 때문에 오른쪽이 길어짐
          root.bal = -1;
          break;
        case -1: // 오른쪽이 긴 상태에서 또 오른쪽에 넣어줬으므로 RR 또는 LR
          root = this._insRightBal(root);
          break;
      }
    }
    return root;
  }
};

AVL.prototype._insLeftBal = function (root) {
  var left = root.left;
  console.log("insLeftBal", left.bal);
  switch (left.bal) {
    case 1: // LL의 경우입니다.
      root.bal = 0;
      left.bal = 0;
      root = this._rotateRight(root); // 우회전 한 번
      this.taller = false;
      break;
    case 0: // 균형인 경우는 없습니다.
      throw new Error("불가능한 경우");
    case -1: // RL의 경우입니다.
      var right = left.right;
      switch (right.bal) {
        case 1:
          root.bal = -1;
          left.bal = 0;
          break;
        case 0:
          root.bal = 0;
          left.bal = 1;
          break;
        case -1:
          root.bal = 0;
          left.bal = 1;
          break;
      }
      right.bal = 0;
      root.left = this._rotateLeft(left); // 좌회전 후
      root = this._rotateRight(root); // 우회전
      this.taller = false;
  }
};

AVL.prototype._insRightBal = function (root) {
  var right = root.right;
  console.log("insRightBal", right.bal);
  switch (right.bal) {
    case -1: // RR의 경우입니다.
      root.bal = 0;
      right.bal = 0;
      root = this._rotateLeft(root); // 좌회전 한 번
      this.taller = false;
      break;
    case 0: // 균형일 수는 없습니다.
      throw new Error("불가능한 경우");
    case 1:
      var left = right.left;
      switch (
        left.bal // LR의 경우입니다.
      ) {
        case 1:
          root.bal = -1;
          right.bal = 0;
          break;
        case 0:
          root.bal = 0;
          right.bal = 1;
          break;
        case -1:
          root.bal = 0;
          right.bal = 1;
          break;
      }
      left.bal = 0;
      root.right = this._rotateRight(right); // 우회전 후
      root = this._rotateLeft(root); // 좌회전
      this.taller = false;
  }
  return root;
};

// 3. 삭제부
AVL.prototype._delete = function (root, key) {
  if (!root) {
    // 지울 게 없습니다.
    console.log("no root to delete");
    this.shorter = false;
    this.success = false;
    return;
  }
  if (key < root.data) {
    // 지울 값이 루트 값보다 작으면
    root.left = this._delete(root.left, key);
    console.log("go left", root.left, this.shorter);
    if (this.shorter) {
      // 삭제로 인해 짧아졌으면
      root = this._delRightBal(root);
    }
  } else if (key > root.data) {
    // 지울 값이 루트 값보다 크면
    root.right = this._delete(root.right, key);
    console.log("go right", root.right, this.shorter);
    if (this.shorter) {
      // 삭제로 인해 짧아졌으면
      root = this._delLeftBal(root);
    }
  } else {
    // key와 일치하는 데이터를 찾았을 때
    console.log("found", key, root);
    if (!root.right) {
      // 오른쪽 자식이 없으면 노드가 제거됐을 때 왼쪽 자식이 루트
      var newRoot = root.left;
      this.success = true;
      this.shorter = true;
      return newRoot;
    } else if (!root.left) {
      // 왼쪽 자식이 없으면 노드가 제거됐을 때 오른쪽 자식이 루트
      var newRoot = root.right;
      this.success = true;
      this.shorter = true;
      return newRoot;
    } else {
      // 삭제할 노드를 계속 왼쪽으로 보내서 제거(트리 강좌 참고)
      var temp = root.left;
      while (temp.right) temp = temp.right;
      root.data = temp.data;
      root.left = this._delete(root.left, temp.data);
      if (this.shorter) {
        // 삭제로 짧아졌으면
        root = this._delRightBal(root);
      }
    }
  }
  return root;
};

AVL.prototype._delLeftBal = function (root) {
  console.log("delLeftBal", root, root.bal, root.left);
  switch (root.bal) {
    case 1:
      root.bal = 0;
      break;
    case 0:
      root.bal = -1;
      this.shorter = false;
      break;
    case -1:
      var left = root.left;
      if (left.bal === 1) {
        // RL의 경우
        var right = left.right;
        switch (right.bal) {
          case 1:
            left.bal = -1;
            root.bal = 0;
            break;
          case 0:
            root.bal = 0;
            left.bal = 0;
            break;
          case -1:
            root.bal = 1;
            left.bal = 0;
            break;
        }
        right.bal = 0;
        root.left = this._rotateLeft(left);
        root = this._rotateRight(root);
      } else {
        // LL의 경우
        switch (left.bal) {
          case -1:
            root.bal = 0;
            left.bal = 0;
            break;
          case 0:
            root.bal = -1;
            left.bal = 1;
            this.shorter = false;
            break;
        }
        root = this._rotateRight(root);
      }
  }
  return root;
};

AVL.prototype._delRightBal = function (root) {
  console.log("delRightBal", root, root.bal);
  switch (root.bal) {
    case 1:
      root.bal = 0;
      break;
    case 0:
      root.bal = -1;
      this.shorter = false;
      break;
    case -1:
      right = root.right;
      if (right.bal === 1) {
        // LR의 경우입니다.
        left = right.left;
        console.log("delRightBal LR", left.bal);
        switch (left.bal) {
          case 1:
            right.bal = -1;
            root.bal = 0;
            break;
          case 0:
            root.bal = 0;
            right.bal = 0;
            break;
          case -1:
            root.bal = 1;
            right.bal = 0;
            break;
        }
        left.bal = 0;
        root.right = this._rotateRight(right);
        root = this._rotateLeft(root);
      } else {
        // RR의 경우입니다.
        console.log("delRightBal RR", right.bal);
        switch (right.bal) {
          case 0:
            root.bal = -1;
            right.bal = -1;
            this.shorter = false;
            break;
          case -1:
            root.bal = 0;
            right.bal = 0;
            break;
        }
        root = this._rotateLeft(root);
      }
  }
  return root;
};

// 4. 실행부분
var avlTree = new AVL(); // 한 줄씩 치면서 어떻게 트리가 변하나 확인해보세요.
avlTree.insert(8);
avlTree.insert(12);
avlTree.insert(14);
avlTree.insert(18);
avlTree.insert(20);
avlTree.insert(23);
avlTree.insert(44);
avlTree.insert(52);
avlTree.delete(20);
```

[Top](#알고리즘)

---

## 그래프

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/584b9033580277001862f16c)

```javascript
var Graph = (function () {
  function Vertex(key) {
    this.next = null;
    this.arc = null;
    this.key = key;
    this.inTree = null;
  }
  function Arc(data, dest, capacity) {
    this.nextArc = null;
    this.destination = dest;
    this.data = data;
    this.capacity = capacity;
    this.inTree = null;
  }
  function Graph() {
    this.count = 0;
    this.first = null;
  }
  Graph.prototype.insertVertex = function (key) {
    var vertex = new Vertex(key);
    var last = this.first;
    if (last) {
      while (last.next !== null) {
        last = last.next;
      }
      last.next = vertex;
    } else {
      this.first = vertex;
    }
    this.count++;
  };
  Graph.prototype.deleteVertex = function (key) {
    var vertex = this.first;
    var prev = null;
    while (vertex.key !== key) {
      prev = vertex;
      vertex = vertex.next;
    }
    if (!vertex) return false;
    if (!vertex.arc) return false;
    if (prev) {
      prev.next = vertex.next;
    } else {
      this.first = vertex.next;
    }
    this.count--;
  };
  Graph.prototype.insertArc = function (data, fromKey, toKey, capacity) {
    var from = this.first;
    var to = this.first;
    while (from && from.key !== fromKey) {
      from = from.next;
    }
    while (to && to.key !== toKey) {
      to = to.next;
    }
    if (!from || !to) return false;
    var arc = new Arc(data, to, capacity);
    var fromLast = from.arc;
    if (fromLast) {
      while (fromLast.nextArc != null) {
        fromLast = fromLast.nextArc;
      }
      fromLast.nextArc = arc;
    } else {
      from.arc = arc;
    }
  };
  Graph.prototype.deleteArc = function (fromKey, toKey) {
    var from = this.first;
    while (from !== null) {
      if (from.key === fromKey) break;
      from = from.next;
    }
    if (!from) return false;
    var fromArc = from.arc;
    var preArc;
    while (fromArc !== null) {
      if (toKey === fromArc.destination.key) break;
      preArc = fromArc;
      fromArc = fromArc.next;
    }
    if (!fromArc) return false;
    if (preArc) {
      preArc.nextArc = fromArc.nextArc;
    } else {
      from.arc = fromArc.nextArc;
    }
  };
  return Graph;
})();

var graph = new Graph();
graph.insertVertex("A");
graph.insertVertex("B");
graph.insertVertex("C");
graph.insertVertex("D");
graph.insertVertex("E");
graph.insertVertex("F");
graph.insertArc(1, "A", "B");
graph.insertArc(1, "B", "C");
graph.insertArc(1, "B", "E");
graph.insertArc(1, "C", "E");
graph.insertArc(1, "C", "D");
graph.insertArc(1, "E", "D");
graph.insertArc(1, "E", "F");

/* 무방향 그래프
function insertTwoWayArc(graph, data, from, to) {
  graph.insertArc(data, from, to);
  graph.insertArc(data, to, from);
} */
```

[Top](#알고리즘)

---

## 해쉬

- 출처 : [Evan Moon님 사이트](https://evan-moon.github.io/2019/06/25/hashtable-with-js/)

```javascript
```

[Top](#알고리즘)

---

## Level-1

- 문제 출처 : [프로그래머스](https://programmers.co.kr/learn/challenges?tab=all_challenges)
- 풀이 출처 : [출처 : kwonh님 Velog](https://velog.io/@kwonh/Algorithm-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%A0%88%EB%B2%A81-%ED%92%80%EC%9D%B4-%EB%AA%A8%EC%9D%8C-Javascript)

### [1차] 다트 게임

- 문제 : [프로그래머스](https://programmers.co.kr/learn/courses/30/lessons/17682?language=javascript)
- 풀이

```javascript
function solution(dartResult) {
  let origin = [...dartResult].reduce((arr, v, i) => {
    if (v === "0" && arr[i - 1] === "1") return [...arr, "10"];
    if (v === "1" && arr[i + 1] === "0") return [...arr];
    return [...arr, v];
  }, []);
  let scores = [];
  origin.forEach((v, i) => {
    const len = scores.length;
    if (v === "S") scores.push(origin[i - 1] / 1);
    if (v === "D") scores.push(Math.pow(origin[i - 1] / 1, 2));
    if (v === "T") scores.push(Math.pow(origin[i - 1] / 1, 3));
    if (v === "*") {
      const hasBefore = len >= 2;
      if (hasBefore) scores[len - 2] = scores[len - 2] * 2;
      scores[len - 1] = scores[len - 1] * 2;
    }
    if (v === "#") scores[len - 1] = scores[len - 1] - 2 * scores[len - 1];
  });
  return scores.reduce((accum, v) => accum + v, 0);
}
```

- 매개변수 dartResult에서 넘어오는 문자열에서 10점을 분리하는 과정(1-9는 한 자리, 10은 두 자리)을 거치지 않아 수정이 필요했었다.
- 처음 만들었을 때 세 개의 배열 SDT, options, scores로 각각 분리한 뒤 처리하는 로직으로 만들었는데 비효율적인 것 같아 최대한 배열생성을 자제하며 수정했다.

[Top](#알고리즘)

---
