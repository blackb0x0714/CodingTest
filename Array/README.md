# Array

- 출처 : [Cookie님 Velog](https://velog.io/@ryu/JavaScript-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-Array%EB%B0%B0%EC%97%B4)

---

## 선언하기

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

## 속성 및 내장 메소드 사용하기

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

## 기존 배열을 변경하지 않는 메소드

- concat()
- join()
- slice()

---

## 배열 순회하기

- forEach()
- for in
- for of
- map

### forEach()

- 배열 요소를 반복하며 특정 작업을 수행할 수 있으며, Array 타입에서만 사용가능한 메서드입니다.
- forEach()의 안자로 callback 함수를 등록할 수 있습니다.
- callback 함수 내에서는 index와 배열 요소값에 접근할 수 있습니다.

```javascript
const array = [1, 2, 3];
array.forEach((item, index) => console.log(`${item}...${index}`)); // 1...0 , 2...1 , 3...2
```

### for in

- 객체에 사용할 수 있으며, 객체의 key와 value 값을 추출해내는데 사용합니다.
- 객체의 key 갯수만큼 반복합니다.

```javascript
const array = [1, 2, 3];
for (let key in array) {
  console.log(`${array[key]}...${key}`); // 1...0 , 2...1 , 3... 2
}
```

### for of

- ES6 에 추가된, 컬렉션 전용 반복구문 입니다.
- for of 를 사용하려면 컬렉션 객체가 [Symbol.iterator] 속성을 가지고 있어야만 합니다.

```javascript
const array = [1, 2, 3];
for (let item of array) {
  console.log(`${item}`);
} // 1, 2, 3
```

### map

- 리스트의 요소를 순회하며 현재 index의 요소의 데이터를 가공하여 새로운 리스트로 반환합니다.

```javascript
const array = [1, 2, 3];
const newArray = array.map((item) => item + 1); // [2, 3, 4]
```
