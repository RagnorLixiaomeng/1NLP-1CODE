package code.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * BackTrackingForCombination
 * 
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

    示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
#
 */
public class BackTrackingForCombination {

    // step-01 : 递归函数的返回值以及参数 ==》 需要存放符合条件的单一结果；存放符合条件的结果的集合；既然函数是从集合n里面取k个数那n和k必在函数的参数中，然后还需要一个startIndex，因为下一层递归需要知道如何取数
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }

    public void backtracking(int n,int k,int startIndex){

        // step-02 : 回溯函数终止条件
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        // step-03 :单层搜索的过程
        for (int i =startIndex;i<=n;i++){
            path.add(i);
            backtracking(n,k,i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        BackTrackingForCombination btfc = new BackTrackingForCombination();
        List<List<Integer>> result = btfc.combine(4, 2);
        System.out.println(result);
    }

}