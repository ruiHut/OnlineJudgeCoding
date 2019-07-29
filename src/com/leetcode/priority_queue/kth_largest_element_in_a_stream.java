// 优先队列
class KthLargest {
    final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a)
            q.add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.add(n);
        else if (q.peek() < n) {
            q.poll();
            q.add(n);
        }
        return q.peek();
    }
}

// 最小堆
class KthLargest {

    // use arrry
    private int[] heap;
    
    public KthLargest(int k, int[] nums) {
        heap = new int[k];
        Arrays.fill(heap, Integer.MIN_VALUE);
        Arrays.fill(heap, Integer.MIN_VALUE);
        // build min heap
        for (int i = (k - 1) / 2; i >= 0; i--)
            adjustHeap(heap, i, k);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > heap[0]) {
                heap[0] = nums[i];
                adjustHeap(heap, 0, k);
            }
        }
    }
    
    public int add(int val) {
        if (val > heap[0]) {
            heap[0] = val;
            adjustHeap(heap, 0, heap.length);
        }
        return heap[0];
    }
    
    private void adjustHeap(int[] heap, int i, int len) {
        int num = heap[i];
        while (i * 2 + 1 < len) {
            int next = i * 2 + 1;
            if (next + 1 < len && heap[next] > heap[next + 1]) {
                next++;
            }
            if (heap[next] > num) break;
            heap[i] = heap[next];
            i = next;
        }
        heap[i] = num;
    }
}