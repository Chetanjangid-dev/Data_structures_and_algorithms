var findKthLargest = function(nums, k) {
   class MinHeap {
  constructor(heap = []) {
    this.heap = heap;
  }

  getParent(i) {
    return Math.floor((i - 1) / 2);
  }

  getLeft(i) {
    return 2 * i + 1;
  }

  getRight(i) {
    return 2 * i + 2;
  }

  swap(i, j) {
    [this.heap[i], this.heap[j]] =
    [this.heap[j], this.heap[i]];
  }

  heapifyUp(i = this.heap.length - 1) {

    while (i > 0) {

      let parent = this.getParent(i);

      if (this.heap[parent] <= this.heap[i])
        break;

      this.swap(parent, i);

      i = parent;
    }
  }

  heapifyDown(i = 0, limit = this.heap.length) {

    while (true) {

      let smallest = i;

      let left = this.getLeft(i);
      let right = this.getRight(i);

      if (
        left < limit &&
        this.heap[left] < this.heap[smallest]
      ) {
        smallest = left;
      }

      if (
        right < limit &&
        this.heap[right] < this.heap[smallest]
      ) {
        smallest = right;
      }

      if (smallest === i) break;

      this.swap(i, smallest);

      i = smallest;
    }
  }

  insert(val) {

    this.heap.push(val);

    this.heapifyUp();
  }

  extractMin() {

    if (this.heap.length === 0)
      return null;

    if (this.heap.length === 1)
      return this.heap.pop();

    let min = this.heap[0];

    // last element ko root pe lao
    this.heap[0] = this.heap.pop();

    // heap fix karo
    this.heapifyDown();

    return min;
  }

  buildHeap(k = this.heap.length) {

    for (
      let i = Math.floor(k / 2) - 1;
      i >= 0;
      i--
    ) {
      this.heapifyDown(i, k);
    }
  }

  peek() {
    return this.heap[0];
  }

  size() {
    return this.heap.length;
  }
}
let h=new MinHeap();
newmemo=[]
for(let i=nums.length-1;i>=nums.length-k;i--){
    newmemo.push(nums[i])
}
h.heap=newmemo
h.buildHeap()
for(let i=0; i<nums.length-k;i++){
      if(nums[i]>h.peek()){
        h.extractMin()
        h.insert(nums[i])
      }
}
 return h.peek()
};