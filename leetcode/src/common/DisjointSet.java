package common;

public class DisjointSet {
    int[] parent;
    public DisjointSet(int size) {
        parent = new int[size+1];
    }

    public void makeset(int i){
        parent[i]=i;
    }

    public int find(int x){
        if(parent[x]!=x){
            return find(parent[x]);
        }else{
            return x;
        }
    }

    public void union(int x, int y){
        parent[find(x)] = find(y);
    }
}
