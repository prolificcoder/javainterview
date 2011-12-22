package com.code.prolificcoder;

public class Amazon5 {
 
        /**
         * @param args
         */
        public static void main(String[] args) {
                // TODO Auto-generated method stub
                int[] a = new int[]{32,3,1,213,42,3,13,3};
                int p = 0;
                int r = a.length-1;
                int i=4;
                System.out.print(quickSelect(a,p,r,i));
        
        }
        
        private static int quickSelect(int[] a,int p,int r, int i)
        {
                if(p==r) return p;
                int q=randomizedPartition(a, p, r);
                int k=q-p+1;
                if(i==k)
                        return q;
                else if(i<k)
                        return quickSelect(a, p, q-1, i);
                else
                        return quickSelect(a, q+1, r, i-k);
        }
 
        private static int randomizedPartition(int[] a, int p, int r) {
                // TODO Auto-generated method stub
                int n = (int)((r-p+1) * Math.random())  ;
                n=n+p;
                int x = a[n];
                a[n]=a[r];
                a[r]=x;
                return partition(a,p,r);
        }
 
        private static int partition(int[] a, int p, int r) {
                // TODO Auto-generated method stub
                int x  = a[r];
                int i  = p-1;
                for(int j=p;j<r;j++)
                {
                        if(a[j]<=x)
                        {
                                i=i+1;
                                int temp = a[j];
                                a[j]=a[i];
                                a[i]=temp;
                        }       
                }
                int temp = a[r];
                a[r]=a[i+1];
                a[i+1]=temp;
                return i+1;
        }
 
}
