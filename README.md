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

# 자료구조

- [배열(Array)](#배열)
- [연결리스트(LinkedList)](#연결리스트)
- [스택(Stack)](#스택)
- [큐(Queue)](#큐)
- [트리(Tree)](#트리)
- [힙(Heap)](#힙)
- [트리(Tree)](#트리)
- [AVL 트리(Tree)](#AVL-트리)
- [그래프(Graph)](#그래프)
- [해쉬(Hash)](#해쉬)

# JS 100제

- [문제 1~50](https://www.notion.so/JS-100-1-0465a498481c471488646526a181087f)
- [문제 51~100](https://www.notion.so/JS-100-2-327372e894a843cf9c9430070c1ce5da)
  <br>
- 출처 : [제주코딩베이스캠프](https://www.notion.so/JS-100-94d97d294dd14c9b911a02c840fa9f2d)

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

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/584b979a580277001862f182)

- 막대기 자르기

```javascript
var p = [0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30];
function cutRod(p, n) {
  var r = [0];
  for (var j = 1; j <= n; j++) {
    q = -1;
    for (var i = 1; i <= j; i++) {
      q = Math.max(q, p[i] + r[j - i]);
    }
    r[j] = q;
  }
  return r[n];
}
cutRod(p, 2); // 5
cutRod(p, 3); // 8
cutRod(p, 4); // 10
cutRod(p, 7); // 18
```

- 최장 공통 부분 수열 문제

```javascript
function LCS(x, y) {
  var i = x.length;
  var j = y.length;
  var result = [];
  for (var k = 0; k <= i; k++) {
    if (!result[k]) {
      result[k] = []; // 이전 계산 값 저장 공간
    }
  }
  for (k = 0; k <= i; k++) {
    for (var l = 0; l <= j; l++) {
      console.log(k, l);
      if (k === 0 || l === 0) {
        // 베이스 값 설정
        result[k][l] = 0;
      } else if (x[k - 1] === y[l - 1]) {
        // 마지막 두 문자 비교, 같으면
        result[k][l] = result[k - 1][l - 1] + 1;
      } else {
        // 마지막 두 문자가 다르면
        result[k][l] = Math.max(result[k - 1][l], result[k][l - 1]);
      }
    }
  }
  return result[i][j];
}
LCS("ABCBDAB", "BDCABA"); // 4
```

- 0/1 배낭 문제

```javascript
var item = [
  [1, 60, 10],
  [2, 100, 20],
  [3, 120, 30],
];
function zeroOneKnapsack(item, cap) {
  var m = [];
  for (var i = 0; i <= item.length; i++) {
    m[i] = [];
  }
  for (i = 0; i < item.length + 1; i++) {
    for (var j = 0; j <= cap; j++) {
      if (i === 0 || j === 0) {
        // 물건이나 무게가 없음
        m[i][j] = 0;
      } else if (item[i - 1][2] > j) {
        // 물건의 무게가 j보다 크면
        m[i][j] = m[i - 1][j];
      } else {
        m[i][j] = Math.max(
          m[i - 1][j],
          m[i - 1][j - item[i - 1][2]] + item[i - 1][1]
        );
      }
    }
  }
  return m[item.length][cap];
}
zeroOneKnapsack(item, 50); // 220
```

[Top](#알고리즘)

---

## 탐욕 알고리즘

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/584ba5c9580277001862f188)

- 활동 선택 문제

```javascript
var activity = [
  [1, 1, 3],
  [2, 2, 5],
  [3, 4, 7],
  [4, 1, 8],
  [5, 5, 9],
  [6, 8, 10],
  [7, 9, 11],
  [8, 11, 14],
  [9, 13, 16],
];
function activitySelection(act) {
  var result = [];
  var sorted = act.sort(function (prev, cur) {
    return prev[2] - cur[2]; // 끝나는 시간 순으로 정렬
  });
  var last = 0;
  sorted.forEach(function (item) {
    if (last < item[1]) {
      // 조건 만족 시 결과 집합에 추가
      last = item[2];
      result.push(item);
    }
  });
  return result.map(function (r) {
    return r[0]; // map을 한 이유는 그냥 몇 번째 행동이 선택되었는지 보여주기 위함.
  });
}
activitySelection(activity); // [1, 3, 6, 8]
```

- 분할 가능 배낭 문제

```javascript
var test = [
  [1, 60, 10],
  [2, 100, 20],
  [3, 120, 30],
];
function fractionalKnapsack(item, w) {
  var sorted = item.sort(function (prev, cur) {
    return cur[1] / cur[2] - prev[1] / prev[2]; // 무게 대비 가치 순으로 정렬
  });
  var limit = w;
  var result = 0;
  for (var i = 0; i < sorted.length; i++) {
    var cur = sorted[i];
    if (limit > 0) {
      if (limit >= cur[2]) {
        // 물건 무게가 제한 이하일 경우
        limit -= cur[2];
        result += cur[1];
      } else {
        // 물건 무게가 제한 초과일 경우
        result += (cur[1] / cur[2]) * limit; // 잘라서 넣음
        limit = 0;
      }
    } else {
      break;
    }
  }
  return result;
}
fractionalKnapsack(test, 50); // 240
```

[Top](#알고리즘)

---

## 최소 신장 트리

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/584bcd42580277001862f1a7)

- 프림 알고리즘

```javascript
Graph.prototype.mst = function () {
  var first = this.first;
  var inTreeCount = 0;
  while (first) {
    // 모든 inTree를 false로 초기화
    first.inTree = false;
    var arc = first.arc;
    while (arc) {
      arc.inTree = false;
      arc = arc.nextArc;
    }
    first = first.next;
  }
  this.first.inTree = true; // 첫 버텍스를 MST에 넣습니다.
  inTreeCount++;
  console.log("%s 버텍스가 추가되었습니다.", this.first.key);
  var temp = this.first;
  var current;
  var minArc; // 최소 아크를 저장
  var minTemp; // 최소 아크의 출발 버텍스를 저장
  while (inTreeCount != this.count) {
    // 모든 버텍스를 추가할 때까지
    while (temp) {
      current = temp;
      temp = temp.next;
      if (!current.inTree) continue;
      arc = current.arc;
      while (arc) {
        if (!arc.destination.inTree) {
          if (!minArc) minArc = arc;
          if (minArc.data > arc.data) {
            // 기존 최솟값보다 더 작은 값을 찾았을 때
            minArc = arc; // 최소 아크를 찾음
            minTemp = current; // 최소 아크의 출발 버텍스 저장
          }
        }
        arc = arc.nextArc;
      }
    }
    minArc.destination.inTree = true;
    minArc.inTree = true;
    inTreeCount++;
    console.log(
      "%s 버텍스에서 %s 버텍스로 향하는 가중치 %d의 아크가 추가되었습니다.",
      minTemp.key,
      minArc.destination.key,
      minArc.data
    );
    minArc = null;
    temp = this.first;
  }
};

var graph = new Graph();
graph.insertVertex("A");
graph.insertVertex("B");
graph.insertVertex("C");
graph.insertVertex("D");
graph.insertVertex("E");
graph.insertVertex("F");
insertTwoWayArc(graph, 6, "A", "B");
insertTwoWayArc(graph, 3, "A", "C");
insertTwoWayArc(graph, 2, "B", "C");
insertTwoWayArc(graph, 5, "B", "D");
insertTwoWayArc(graph, 3, "C", "D");
insertTwoWayArc(graph, 4, "C", "E");
insertTwoWayArc(graph, 2, "D", "E");
insertTwoWayArc(graph, 3, "D", "F");
insertTwoWayArc(graph, 5, "E", "F");
graph.mst();
// A 버텍스가 추가되었습니다.
// A 버텍스에서 C 버텍스로 향하는 가중치 3의 아크가 추가되었습니다.
// C 버텍스에서 B 버텍스로 향하는 가중치 2의 아크가 추가되었습니다.
// C 버텍스에서 D 버텍스로 향하는 가중치 3의 아크가 추가되었습니다.
// D 버텍스에서 E 버텍스로 향하는 가중치 2의 아크가 추가되었습니다.
// D 버텍스에서 F 버텍스로 향하는 가중치 3의 아크가 추가되었습니다.
```

[Top](#알고리즘)

---

## 최단 경로 알고리즘

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/584bd46f580277001862f1af)

- 다익스트라 알고리즘

```javascript
Graph.prototype.shortest = function (startKey) {
  var from = this.first;
  while (from) {
    if (from.key === startKey) {
      break;
    }
    from = from.next;
  }
  console.log("시작점은 %s입니다", from.key);
  var temp = this.first;
  var current;
  var arc;
  while (temp) {
    // 모든 버텍스 최단거리를 Infinity로 초기화
    temp.distance = Infinity;
    temp = temp.next;
  }
  temp = this.first;
  temp.distance = 0;
  while (temp) {
    // 반복문을 돌며 최단 거리를 찾음
    current = temp;
    temp = temp.next;
    arc = current.arc;
    while (arc) {
      if (arc.destination.distance > current.distance + arc.data) {
        arc.destination.distance = current.distance + arc.data;
      }
      arc = arc.nextArc;
    }
  }
  temp = this.first;
  while (temp) {
    console.log("%s까지의 최단 거리는 %d입니다", temp.key, temp.distance);
    temp = temp.next;
  }
};

var graph = new Graph();
graph.insertVertex("A");
graph.insertVertex("B");
graph.insertVertex("C");
graph.insertVertex("D");
graph.insertVertex("E");
graph.insertVertex("F");
insertTwoWayArc(graph, 6, "A", "B");
insertTwoWayArc(graph, 3, "A", "C");
insertTwoWayArc(graph, 2, "B", "C");
insertTwoWayArc(graph, 5, "B", "D");
insertTwoWayArc(graph, 3, "C", "D");
insertTwoWayArc(graph, 4, "C", "E");
insertTwoWayArc(graph, 2, "D", "E");
insertTwoWayArc(graph, 3, "D", "F");
insertTwoWayArc(graph, 5, "E", "F");
graph.shortest("A");
// A까지의 최단 거리는 0입니다.
// B까지의 최단 거리는 5입니다.
// C까지의 최단 거리는 3입니다.
// D까지의 최단 거리는 6입니다.
// E까지의 최단 거리는 7입니다.
// F까지의 최단 거리는 9입니다.
```

[Top](#알고리즘)

---

## 그래프 탐색

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/5870153c37e1c80018b64eb0)

- DFS

```javascript
Graph.prototype.dfs = function () {
  var stack = new Stack();
  var temp = this.first;
  while (temp) {
    temp.inTree = false;
    temp = temp.next;
  }
  temp = this.first;
  stack.push(temp); // 스택에 첫 버텍스를 넣음
  temp.inTree = true;
  while (stack.count) {
    // 탐색을 완료할 때까지
    temp = stack.pop(); // 넣었던 버텍스를 하나씩 꺼냄
    console.log(temp.key);
    temp.inTree = true;
    var arc = temp.arc;
    while (arc) {
      if (!arc.destination.inTree) {
        stack.push(arc.destination); // 꺼낸 것과 연결된 버텍스들을 스택에 넣음
        arc.destination.inTree = true;
      }
      arc = arc.nextArc;
    }
  }
};
graph.dfs(); // A, X, H, P, E, Y, M, J, G
```

- BFS

```javascript
Graph.prototype.bfs = function () {
  var queue = new Queue();
  var temp = this.first;
  while (temp) {
    temp.inTree = false;
    temp = temp.next;
  }
  temp = this.first;
  queue.enqueue(temp); // 첫 버텍스를 큐에 넣음
  temp.inTree = true;
  while (queue.count) {
    // 탐색을 완료할 때까지
    temp = queue.dequeue(); // 큐에서 하나씩 꺼냄
    console.log(temp.key);
    temp.inTree = true;
    var arc = temp.arc;
    while (arc) {
      if (!arc.destination.inTree) {
        queue.enqueue(arc.destination); // 꺼낸 것과 연결된 버텍스들을 큐에 넣음
        arc.destination.inTree = true;
      }
      arc = arc.nextArc;
    }
  }
};
graph.bfs(); // A, X, G, H, P, E, M, Y, J
```

[Top](#알고리즘)

---

## 네트워크 플로우

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm/post/5893405b588acb00186d39e0)

```javascript
Graph.prototype.fordFulkerson = function(start, end) {
  function ReArc(data, dest) { // 잔여 아크 생성자 선언
    this.data = data || 0;
    this.destination = dest;
    this.reverse = null;
  }
  var vertex = this.first;
  while (vertex) { // 모든 아크에 잔여 아크를 추가하는 작업
    var arc = vertex.arc;
    while (arc) {
      var reArc = new ReArc(arc.capacity - arc.data, arc.destination);
      var reArc2 = new ReArc(arc.data, vertex);
      reArc.reverse = reArc2; // 두 잔여 아크는 서로 역방향의 관계
      reArc2.reverse = reArc;
      vertex.residual = vertex.residual || [];
      vertex.residual.push(reArc);
      arc.destination.residual = arc.destination.residual || [];
      arc.destination.residual.push(reArc2);
      arc = arc.nextArc;
    }
    vertex = vertex.next;
  }
  var self = this;

  function findArcInPath(path, reArc, start) { // 잔여 아크가 이미 지나온 경로 안에 있는지 찾는 함수
    for (var i = 0; i < path.length; i++) {
      if (path[i][0] === reArc || reArc.destination === path[i][2]) {
         return true;
      }
    }
    return false;
  }

  function findPath(from, to, path) { // 잔여 네트워크의 경로를 재귀적으로 찾는 함수
    if (from === to) return path;
    vertex = self.first;
    var reArcs;
    var arc;
    while (vertex) {
      if (vertex.key === from)
        reArcs = vertex.residual;
        arc = vertex.arc;
        break;
      }
      vertex = vertex.next;
    }
    for (var i = 0; i < reArcs.length; i++) { // 잔여 아크 전체를 탐색
      var residual = reArcs[i].data;
      if (residual > 0 && !findArcInPath(path, reArcs[i], vertex)) { // 잔여 아크 용량이 1 이상이고 지나온 패스에 없으면
         var pathCopy = path.slice();
         pathCopy.push([reArcs[i], arc, vertex]);
        var result = findPath(reArcs[i].destination.key, to, pathCopy); // 재귀적으로 다음 패스를 찾음
        if (result) return result;
      }
    }
    return null;
  }

  var path = findPath(start, end, []);
  while (path) { // 잔여 네트워크에 경로가 없을 때까지 반복적으로 찾고 증강
    var flow = Infinity;<
    for (var i = 0; i < path.length; i++) {
      if (path[i][0].data < flow) flow = path[i][0].data; // 추가할 수 있는 물의 양 찾기
    }
    for (var i = 0; i < path.length; i++) {
      path[i][0].data -= flow; // 잔여 아크에 흐름 뺌
      path[i][0].reverse.data += flow; // 잔여 역아크에 흐름 추가
      path[i][1].data += flow; // 아크에 흐름 추가
    }
    path = findPath(start, end, []);
  }
  var sum = 0;
  vertex = self.first;
  while (vertex) { // 마지막으로 시작점의 유량을 체크하면
    if (vertex.key === start) {
      arc = vertex.arc;
      while (arc) {
        sum += arc.data;
        arc = arc.nextArc;
      }
      break;
    }
    vertex = vertex.next;
  }
  return sum;
};

var graph = new Graph();
graph.insertVertex('s');
graph.insertVertex('w');
graph.insertVertex('y');
graph.insertVertex('x');
graph.insertVertex('z');
graph.insertVertex('t');
graph.insertArc(1, 's', 'w', 3);
graph.insertArc(2, 'w', 'x', 2);
graph.insertArc(2, 'x', 't', 3);
graph.insertArc(2, 's', 'y', 2);
graph.insertArc(1, 'y', 'w', 3);
graph.insertArc(1, 'x', 'y', 1);
graph.insertArc(2, 'y', 'z', 3);
graph.insertArc(1, 'z', 'x', 3);
graph.insertArc(1, 'z', 't', 2);
graph.fordFulkerson('s', 't'); // 4
```

[Top](#알고리즘)

---

## 배열

- 출처 : [Cookie님 Velog](https://velog.io/@ryu/JavaScript-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-Array%EB%B0%B0%EC%97%B4)

---

### 선언하기

- 배열은 Array 생성자로 생성된 Array 타입의 객체입니다.

```javascript
// 선언방법 1.
const array1 = new Array();
array1[0] = 1;

// 선언방법 2.
const array2 = new Array(1, 2, 3);

// 선언방법 3.
const array3 = [1, 2, 3];
```

---

### 속성 및 내장 메소드 사용하기

- indexOf, push, pop, length, shift, concat, join, reverse, sort, slice, splice

```javascript
// indexOf
const arrayIndexOf = [1, 2, 3];
console.log(arrayIndexOf.indexOf(2)); // 2의 인덱스는? 1
console.log(arrayIndexOf.indexOf(5)); // 5의 인덱스는? -1 (없음)

// push
const arrayPush = [1, 2, 3];
arrayPush.push(4); // array = [1, 2, 3, 4]

// pop
const arrayPop = [1, 2, 3];
arrayPop.pop(); // array = [1, 2]

// length
const arrayLegnth = [1, 2, 3];
console.log(arrayLength.length); // 3

// shift: 배열 첫번째 요소를 제거
const arrayTest = ['a', 'b', 'c'];
arrayTest.shift(); // 'a'
console.log(arrayTest); // ['b', 'c']

 concat : 두개의 배열을 합쳐서 새 배열로 반환
 const arrayConcat = [1, 2, 3];
 console.log(arrayConcat.concat(4)); // [1, 2, 3, 4] 4추가
 console.log(arrayConcat.contact(['a', 'b', 'c'])); [1, 2, 3, 'a', 'b', 'c']

 // join : 배열 요소 사이에 문자를 삽입하여 문자열 반환
 const arrayJoin = [1, 2, 3, 4, 5];
 console.log(arrayJoin.join('/')); // 1/2/3/4/5

 // reverse : 배열을 뒤집음
 const arrayReverse = [1, 2, 3]
 arrayReverse.reverse();
 console.log(arrayReverse); [3, 2, 1]

 // sort : 배열을 정렬
 const arraySort = [5, 3, 1];
 arraySort.sort();
 console.log(arraySort); // [1, 3, 5]

 // slice : 배열의 일부를 새 배열로 반환
const arraySlice = [1, 2, 3, 4, 5];
arraySlice.slice(1, 3); // [2, 3] slice(start[, end])

// splice : 기존 배열의 요소를 제거하고, 제거한 요소를 새 배열로 반환
const arraySplice = [1, 2, 3, 4];
const test = arraySplice.splice(1, 2); // [2, 3]
console.log(arraySplice); // [1, 4]
```

### 기존 배열을 변경하지 않는 메소드

- concat()
- join()
- slice()

---

### 배열 순회하기

- forEach()
- for in
- for of
- map

#### forEach()

- 배열 요소를 반복하며 특정 작업을 수행할 수 있으며, Array 타입에서만 사용가능한 메서드입니다.
- forEach()의 안자로 callback 함수를 등록할 수 있습니다.
- callback 함수 내에서는 index와 배열 요소값에 접근할 수 있습니다.

```javascript
const array = [1, 2, 3];
array.forEach((item, index) => console.log(`${item}...${index}`)); // 1...0 , 2...1 , 3...2
```

#### for in

- 객체에 사용할 수 있으며, 객체의 key와 value 값을 추출해내는데 사용합니다.
- 객체의 key 갯수만큼 반복합니다.

```javascript
const array = [1, 2, 3];
for (let key in array) {
  console.log(`${array[key]}...${key}`); // 1...0 , 2...1 , 3... 2
}
```

#### for of

- ES6 에 추가된, 컬렉션 전용 반복구문 입니다.
- for of 를 사용하려면 컬렉션 객체가 [Symbol.iterator] 속성을 가지고 있어야만 합니다.

```javascript
const array = [1, 2, 3];
for (let item of array) {
  console.log(`${item}`);
} // 1, 2, 3
```

#### map

- 리스트의 요소를 순회하며 현재 index의 요소의 데이터를 가공하여 새로운 리스트로 반환합니다.

```javascript
const array = [1, 2, 3];
const newArray = array.map((item) => item + 1); // [2, 3, 4]
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
- 풀이 출처 : [kwonh님 Velog](https://velog.io/@kwonh/Algorithm-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%A0%88%EB%B2%A81-%ED%92%80%EC%9D%B4-%EB%AA%A8%EC%9D%8C-Javascript)

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
