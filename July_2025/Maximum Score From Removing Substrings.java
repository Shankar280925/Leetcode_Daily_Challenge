class Solution {
    public int maximumGain(String s, int x, int y) {
    int minCharCount=0 , maxCharCount = 0; 
    int maxVal = x>y ? x : y;
    int minVal = x>y ? y : x;

    char maxChar = x>y ? 'a' : 'b';
    char minChar = x>y ? 'b' : 'a';

    int ans = 0;

    for(int i=0; i<s.length(); i++)
    {
     char currChar = s.charAt(i);
     if(currChar==minChar)
     {
         if(maxCharCount>0)
         {
           ans += maxVal;
           maxCharCount--;
         }
         else
            minCharCount++;
     }
     else if(currChar==maxChar)
     {
        maxCharCount++;
     }
     else{
        ans += Math.min(maxCharCount, minCharCount)*minVal;
        maxCharCount = 0;
        minCharCount = 0;
     }

    }

     ans += Math.min(maxCharCount, minCharCount)*minVal;

     return ans;
    }
}
