public class SegmentTreeMax {
    int[] seg;
    int n;

    SegmentTreeMax(int[] arr) {
        n = arr.length;
        seg = new int[4 * n];
        build(0, 0, n - 1, arr);
    }

    private void build(int idx, int low, int high, int[] arr) {
        if (low == high) {
            seg[idx] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        build(2 * idx + 1, low, mid, arr);
        build(2 * idx + 2, mid + 1, high, arr);

        seg[idx] = Math.max(seg[2 * idx + 1], seg[2 * idx + 2]);
    }

    public int query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    private int query(int idx, int low, int high, int l, int r) {
        // no overlap
        if (high < l || low > r) return Integer.MIN_VALUE;

        // complete overlap
        if (low >= l && high <= r) return seg[idx];

        // partial overlap
        int mid = (low + high) / 2;
        int left = query(2 * idx + 1, low, mid, l, r);
        int right = query(2 * idx + 2, mid + 1, high, l, r);
        return Math.max(left, right);
    }

    public void update(int pos, int val) {
        update(0, 0, n - 1, pos, val);
    }

    private void update(int idx, int low, int high, int pos, int val) {
        if (low == high) {
            seg[idx] = val;
            return;
        }
        int mid = (low + high) / 2;

        if (pos <= mid) update(2 * idx + 1, low, mid, pos, val);
        else update(2 * idx + 2, mid + 1, high, pos, val);

        seg[idx] = Math.max(seg[2 * idx + 1], seg[2 * idx + 2]);
    }

    // main method to demonstrate usage
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTreeMax st = new SegmentTreeMax(arr);

        // Query max from index 1 to 3
        System.out.println("Max from 1 to 3: " + st.query(1, 3)); // Output: max(3,5,7)=7

        // Update index 2 to 10
        st.update(2, 10);

        // Query max from 1 to 3 again
        System.out.println("Max from 1 to 3 after update: " + st.query(1, 3)); // Output: max(3,10,7)=10
    }
}
