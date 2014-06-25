package FromGivenTraverseNeedToCheckIfBothWillFormSameBST;

public class BinarySearchTrees<E extends Number> {
	
	
	
boolean	findNumber(E arr[],E arr1[],int max,int min,int n,int i1,int i2){
	int i,j;
	for(i=i1;i<n;i++){
		if(arr[i].intValue()>min && arr[i].intValue()<max)
			break;
		
	}
	for(j=i2;j<n;j++){
		if(arr1[j].intValue()>min && arr1[j].intValue()<max)
			break;
		
	}
	if(i==n && j==n)
		return true;
	if((i==n && j!=n)|| (j==n && i!=n)||arr[i]!=arr1[j])
		return false;
	return 	findNumber(arr,arr1,max,arr[i].intValue(),n,i+1,j+1) &&  	findNumber(arr,arr1,arr[i].intValue(),min,n,i+1,j+1);
		
	}

public static void main(String[] args) {
	Integer a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13};
	Integer b[] = {8, 10, 14, 3, 6, 4, 1, 6, 13};
	   BinarySearchTrees<Integer> bst=new BinarySearchTrees<>();
			   
	System.out.println( bst.findNumber(a,b,Integer.MAX_VALUE,Integer.MIN_VALUE,a.length,0,0));  
	   
}

	
	

}
