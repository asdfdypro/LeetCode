package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (最小高度树)
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 */
public class Solution3 {
    //最低树就是最长边的一半
    //先以任意点为起点，找到最长两条路径   算法错误！！！

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        int[] visited = new int[n];
        List<Integer> path = new ArrayList<>();
        List<Integer> longest = new ArrayList<>();
        List<Integer> longer = new ArrayList<>();

        //从0点出发
        visited[0] = 1;
        path.add(0);
        search(graph, longest,longer,visited, path, 0);

        if(longer.size()==0){
            int pos = longest.size() / 2;
            if (longest.size() % 2 == 0) {
                res.add(longest.get(pos - 1));
            }
            res.add(longest.get(pos));
            return res;
        }

        //合并两条最长路径
int pos=0,len;
        while(longer.get(pos)==longest.get(pos))pos++;
        len=longer.size()-pos;
        if(len<pos){//longest是直径
            pos = longest.size() / 2;
            if (longest.size() % 2 == 0) {
                res.add(longest.get(pos - 1));
            }
            res.add(longest.get(pos));
        }else{//两条路径是最长路径
            len=longest.size()-pos-len+1;

            pos = len / 2+pos-1;
            if (len % 2 == 0) {
                res.add(longest.get(pos - 1));
            }
            res.add(longest.get(pos));
        }
        return res;
    }


    private void search(int[][] graph, List<Integer> longest, List<Integer> longer, int[] visited, List<Integer> path, int form) {
        boolean isLonger = false;
        for (int i = 0; i < graph.length; i++) {
            if (graph[form][i] > 0 && visited[i] == 0) {
                isLonger = true;
                visited[i] = 1;
                path.add(i);
                search(graph, longest, longer, visited, path, i);
                path.remove(path.size() - 1);
                visited[i] = 0;
            }

        }
        if (!isLonger && path.size() > longer.size()) {
            if(path.size() > longest.size()) {
                longer.clear();;
                longer.addAll(longest);
                longest.clear();
                longest.addAll(path);
            }else{
                longer.clear();;
                longer.addAll(path);
            }
        }
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        System.out.println(Arrays.toString(
                solution.findMinHeightTrees(15, new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5},{4,6},{0,7},{4,8},{5,9},{7,10},{6,11},{0,12},{0,13},{3,14}}).toArray()));
    }
}
