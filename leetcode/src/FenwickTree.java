public class FenwickTree {
    int[] tree;

    public FenwickTree(int[] arr) {
        tree = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            updateBinaryIndexedTree(tree, arr[i - 1], i);
        }
    }

    private void updateBinaryIndexedTree(int[] tree, int val, int index) {
        while (index < tree.length) {
            tree[index] += val;
            index = getNext(index);
        }
    }

    public int getSum(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index = getParent(index);
        }

        return sum;
    }

    public void update(int val, int index) {
        while (index < tree.length) {
            tree[index] += val;
            index = getNext(index);
        }
    }

    private int getParent(int x) {
        return x - (x & -x);
    }

    private int getNext(int x) {
        return x + (x & -x);
    }

    public static void main(String[] args) {
        int input[] = {1, 2, 3, 4, 5, 6, 7};
        FenwickTree ft = new FenwickTree(input);
        int ans = ft.getSum(2);
        System.out.println(ans);
        ft.update(10,2);
         ans = ft.getSum(2);
        System.out.println(ans);
    }
}
