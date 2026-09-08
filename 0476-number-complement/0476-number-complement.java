class Solution {
    public int findComplement(int num) {
      int temp = 0;
      int ans = num;
      while(ans != 0){
        temp = (temp << 1) | 1;
        ans >>= 1;
      }
      return num ^ temp;
    }
}