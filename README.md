# 알고리즘

- [Insertion Sort](#삽입-정렬)
- [Merge Sort](#합병-정렬)
- [Bubble Sort](#버블-정렬)
- [Selection Sort](#선택-정렬)
- [Quick Sort](#퀵-정렬)
- [Counting Sort](#계수-정렬)
- [Radix Sort](#기수-정렬)

# 자료구조

- [Linked List](#)
- [Stack](#)
- [Queue](#)
- [Tree](#)
- [Heap](#)
- [Tree](#)
- [Graph](#)

- 출처 : [Zero Cho님 사이트](https://www.zerocho.com/category/Algorithm?page=3)

---

## Best - O(1),O(logN), O(N), O(NlogN), O(N^2), O(N^3), ..., O(2^N), O(N!) - Worst

## 삽입 정렬

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

---

## 합병 정렬

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

---

## 버블 정렬

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

---

## 선택 정렬

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

---

## 퀵 정렬

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

---

## 계수 정렬

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

---

## 기수 정렬

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

---
