# Sort

- [Selection Sort](#선택정렬)
- [Insertion Sort](#삽입정렬)
- [Bubble Sort](#버블정렬)
- [Merge Sort](#병합정렬)
- [Quick Sort](#퀵정렬)
  - 출처 : [위니브즈와 함께하는 벼락치기 코딩](https://www.notion.so/a5a0fafe306e4cb78ec4476a272d156d?v=e116f6cdc6e34075bf8e4c0e56429a26)

---

## 정렬 알고리즘

- 원소들을 번호순이나 사전 순서와 같이 **일정한 순서대로 열거하는 알고리즘**이다.<br>효율적인 정렬은 탐색이나 병합 알고리즘처럼 (정렬된 리스트에서 바르게 동작하는)<br>다른 알고리즘을 최적화하는 데 중요하다.
  - 출처 : [위키백과](https://ko.wikipedia.org/wiki/%EC%A0%95%EB%A0%AC_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)

---

## 정렬 알고리즘 종류

### 선택정렬

- 선택 정렬은 **제자리 비교 정렬**이다.<br>복잡도는 O(n2)이므로 큰 리스트에는 비효율적이며,유사한 삽입 정렬보다 성능이 더 떨어지는 것이 일반적이다.<br>선택 정렬은 단순함이 특징이며 특정한 상황에서는 더 복잡한 알고리즘보다 성능상 우위가 있다.
- 이 알고리즘은 **최소값을 찾고 값을 최초 위치와 바꿔친** 다음 리스트의 나머지 부분에 대해 이 과정을 반복한다.<br>교환 과정은 n개를 넘지 않으므로 교환 비용이 많이 드는 상황에서 유용하다.

- 순서

  1. 주어진 리스트 중에 **최소값(#2)**을 찾는다.
  2. 그 값을 **맨 앞에 위치한 값(#1)**과 **교체(#3)**한다.
  3. 맨 처음 위치를 뺀 **나머지 리스트**를 같은 방법으로 교체한다.

- 출처 : [위키백과](https://ko.wikipedia.org/wiki/%EC%84%A0%ED%83%9D_%EC%A0%95%EB%A0%AC)

- Javascript 코드

```javascript
      // arr : 배열의 전체 값
      // i = 인덱스 값
      // arr[i] : 배열 i번째 값

      function selectionSort(arr) {
        // #1 : 전체 배열의 맨 앞의 값 선택 (인덱스 : i)
        for (let i = 0; i < arr.length; i++) {
          let min_index = i;
          // #2 : #1를 제외한 나머지 배열에서 최소값 탐색 (인덱스 : j)
          for (let j = i + 1; j < arr.length; j++) {
            if (arr[min_index] > arr[j]) {
              min_index = j; //
            }
          }

          // #3 : #2에서 찾아낸 최소값과 #1의 값을 교체
          let temp = arr[min_index];
          arr[min_index] = arr[i];
          arr[i] = temp;
        }
        return arr;
      }
      const arr = [5, 4, 2, 1, 3];
      console.log(selectionSort(arr));
    </script>
```

### 삽입정렬

- 삽입 정렬은 **작은 리스트**와 **대부분 정렬된 리스트**에 상대적으로 효율적인 단순한 정렬 알고리즘이며<br>더 복잡한 알고리즘의 일부분으로 사용되기도 한다.
- 리스트로부터 요소를 하나씩 취한 다음 마치 돈을 지갑에 넣는 방식과 비슷하게 이들을 올바른 위치에,<br>새로 정렬된 리스트에 삽입함으로써 동작한다.<br>배열의 경우 새 리스트와 남아있는 요소들은 배열 공간을 공유할 수 있으나<br>삽입의 경우 잇따르는 모든 요소를 하나씩 이동해야 하므로 비용이 많이 든다.<br>셸소트는 큰 리스트에 더 효율적인 삽입 정렬의 변종이다.
  - 출처 : [위키백과](https://ko.wikipedia.org/wiki/%EC%A0%95%EB%A0%AC_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98#%EC%82%BD%EC%9E%85_%EC%A0%95%EB%A0%AC)

```javascript
function insertIndex(sorted_arr, value) {
  for (let i in sorted_arr) {
    if (value < sorted_arr[i]) {
      return i;
    }
  }
  return sorted_arr.length;
}

function insertSort(arr) {
  let sorted_arr = [];

  while (arr.length != 0) {
    let value = arr.shift();
    let index = insertIndex(sorted_arr, value);
    sorted_arr.splice(index, 0, value);
  }
  return sorted_arr;
}
const arr = [4, 2, 3, 1, 5];
console.log(insertSort(arr));
```

### 버블정렬

- 출처 : [바로가기](https://blog.feruden.com/blog/bubble-sort-in-javascript)

- 버블 정렬 알고리즘은 정렬하는 형태가 버블과 비슷하다고 해서 붙여진 이름이다.<br>내부 구조를 살펴보면 순차적으로 바로 옆에 있는 데이터와 비교해서<br>옆의 데이터가 더 크면 자신과 위치를 교환한다.<br>즉, 첫 번째 데이터가 가장 크다면 계속 옆에 있는 데이터와 자리를 교환하며 해당 데이터는 맨 끝으로 이동하게 된다.<br>이러한 형태가 마치 버블이 보글보글 올라가는 것과 비슷해 보여서 버블 정렬이라고 부른다.

- 버블 정렬 알고리즘은 빅오 표기법으로 표시하면 O(N2)의 시간복잡도를 가지고 있다.

```javascript
function bubbleSort(arr) {
  let result = [...arr]; // 원본 데이터 복사

  for (let i = 0; i < result.length - 1; i++) {
    for (let j = 0; j < result.length - i; j++) {
      if (result[j] > result[j + 1]) {
        let temp = result[j];
        result[j] = result[j + 1];
        result[j + 1] = temp;
      }
    }
  }

  return result;
}
let items = [4, 2, 3, 1, 5];
bubbleSort(items);
```

### 병합정렬

- 합병 정렬 또는 병합 정렬(merge sort)은 O(n log n) 비교 기반 정렬 알고리즘이다.

1. 리스트의 길이가 1 이하이면 이미 정렬된 것으로 본다.<br>그렇지 않은 경우에는
2. 분할(divide) : 정렬되지 않은 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
3. 정복(conquer) : 각 부분 리스트를 [재귀](https://ko.wikipedia.org/wiki/%EC%9E%AC%EA%B7%80%ED%95%A8%EC%88%98)적으로 합병 정렬을 이용해 정렬한다.
4. 결합(combine) : 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다.<br>이때 정렬 결과가 임시배열에 저장된다.
5. 복사(copy) : 임시 배열에 저장된 결과를 원래 배열에 복사한다.
   - 출처 : [위키백과](https://ko.wikipedia.org/wiki/%ED%95%A9%EB%B3%91_%EC%A0%95%EB%A0%AC)

```javascript
function mergeSort(arr) {
  if (arr.length <= 1) {
    return arr;
  }

  const mid = Math.floor(arr.length / 2);
  const left = arr.slice(0, mid);
  const right = arr.slice(mid);

  return merge(mergeSort(left), mergeSort(right));
}

function merge(left, right) {
  let result = [];

  while (left.length && right.length) {
    if (left[0] < right[0]) {
      result.push(left.shift());
    } else {
      result.push(right.shift());
    }
  }

  while (left.length) {
    result.push(left.shift());
  }

  while (right.length) {
    result.push(right.shift());
  }

  return result;
}

const arr = [4, 2, 3, 1, 5, 6];
console.log(mergeSort(arr));
```

### 퀵정렬

- 퀵 정렬은 분할 정복(divide and conquer) 방법을 통해 리스트를 정렬한다.

1. 리스트 가운데서 하나의 원소를 고른다. 이렇게 고른 원소를 **피벗**이라고 한다.
2. 피벗 앞에는 피벗보다 값이 작은 모든 원소들이 오고, 피벗 뒤에는 피벗보다 값이 큰 모든 원소들이 오도록<br>피벗을 기준으로 리스트를 둘로 나눈다.<br>이렇게 리스트를 둘로 나누는 것을 **분할**이라고 한다.<br>분할을 마친 뒤에 피벗은 더 이상 움직이지 않는다.
3. 분할된 두 개의 작은 리스트에 대해 재귀(Recursion)적으로 이 과정을 반복한다.<br>재귀는 리스트의 크기가 0 이나 1이 될 때까지 반복된다.

재귀 호출이 한번 진행될 때마다 최소한 하나의 원소는 최종적으로 위치가 정해지므로,<br>이 알고리즘은 반드시 끝난다는 것을 보장할 수 있다.

- 출처 : [위키백과](https://ko.wikipedia.org/wiki/%ED%80%B5_%EC%A0%95%EB%A0%AC)

```javascript
function quickSort(arr) {
  if (arr.length <= 1) {
    return arr;
  }

  const pivot = arr[0]; // 기준점
  const left = [];
  const right = [];

  for (let i = 1; i < arr.length; i++) {
    if (arr[i] < pivot) {
      left.push(arr[i]);
    } else {
      right.push(arr[i]);
    }
  }
  return quickSort(left).concat(pivot, quickSort(right));
}

const arr = [4, 2, 3, 1, 5];
console.log(quickSort(arr));
```
