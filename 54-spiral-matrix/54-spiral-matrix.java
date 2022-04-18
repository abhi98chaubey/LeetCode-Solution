class Solution
{
public List spiralOrder(int[][] matrix)
{
int minr=0;
int minc=0;
int maxr=matrix.length-1;
int maxc=matrix[0].length-1;
int tne=(maxc+1)*(maxr+1);
int count=0;

    ArrayList<Integer>arrlist=new ArrayList<>();
    
    while(count<tne)
    {
        
        // TOP WALL
        
         for(int i=minr,j=minc;j<=maxc && count<tne ;j++)
         {
             arrlist.add(matrix[i][j]);
             count++;
         }
        minr++;
        
        // RIGHT WALL
        
        for(int i=minr,j=maxc;i<=maxr && count<tne;i++)
        {
            arrlist.add(matrix[i][j]);
            count++;
        }
        maxc--;
        
        // BUTTOM WALL
        
        for(int i=maxr,j=maxc;j>=minc && count<tne;j--)
        {
            arrlist.add(matrix[i][j]);
            count++;
        }
        maxr--;
        
        // LEFT WALL
        
        for(int i=maxr,j=minc;i>=minr && count<tne;i--)
        {
            arrlist.add(matrix[i][j]);
            count++;
        }
        minc++;
        
    }
    
    return arrlist;
    
}
}