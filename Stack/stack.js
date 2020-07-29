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
