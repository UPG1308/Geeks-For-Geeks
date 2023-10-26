
class Solution
{
    public int minOperation(int n)
    {
        //code here.
        int count = 0;
        while(n > 1){
            if (n % 2 == 1) {
                n = n - 1;
            }
            else {
                n = n / 2;
            }
            count++;
        }
        return count + 1;
    }
}
