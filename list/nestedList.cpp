/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */

#include <iostream>
#include <vector>
using namespace std;

class NestedIterator{
  vector<int> output;
  int i = 0;

public:

  void helper(vector<NestedInteger> &nestedList){
    for(int i = 0; i < nestedList.size(); i++){
      if(nestedList[i].isInteger()){
        output.push_back(nestedList[i].getInteger());
      }else{
        helper(nestedList[i].getList());
      }
    }
  }

  NestedIterator(vector<NestedInteger> &nestedList){
    helper(nestedList);
  }

  int next(){
    int ans = output.at(i);
    i++;
    return ans;
  }

  bool hasNext(){
    return i != output.size();
  }
}