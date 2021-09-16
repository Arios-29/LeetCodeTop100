package com.solutions;

import java.util.*;

/**
 * @author ChenYu
 * @date 2021/9/16 20:27
 */
public class SolutionThirtyNine {
    class State{
        private int sum;
        private List<Integer> express;
        private int index;

        public int getIndex() {
            return index;
        }

        public int getSum() {
            return sum;
        }

        public List<Integer> getExpress() {
            return express;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public void setExpress(List<Integer> express) {
            this.express = express;
        }

        public State(){
            sum=0;
            express=new ArrayList<>();
            index=0;
        }

        public State(State last){
            express=new ArrayList<>(last.getExpress());
            sum= last.getSum();
        }
        public void add(int num){
            express.add(num);
            sum+=num;
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
       Queue<State> queue=new ArrayDeque<>();
       State start=new State();
       queue.offer(start);
       List<List<Integer>> ans=new ArrayList<>();
       while(!queue.isEmpty()){
           State cur= queue.poll();
           int sum= cur.getSum();
           if(sum==target){
               ans.add(cur.getExpress());
           }
           else{
               for(int i=cur.getIndex();i<candidates.length;i++){
                   State next=new State(cur);
                   next.add(candidates[i]);
                   next.setIndex(i);
                   if(next.getSum()<=target) {
                       queue.offer(next);
                   }else{
                       break;
                   }
               }
           }
       }
       return ans;
    }
}
