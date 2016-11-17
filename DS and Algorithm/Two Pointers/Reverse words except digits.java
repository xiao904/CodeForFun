/* Input  -> "I have  36 books, 40 pens2, and 1 notebook."
   Output -> "I evah  36 skoob, 40 2snep, dna 1 koobeton."
   */
   
 public class Solution{

    // Input  -> "I have  36 books, 40 pens2, and 1 notebook."
    // Output -> "I evah  36 skoob, 40 2snep, dna 1 koobeton."
    // any string is not pure digits will be reversed
	
     public static String reverse(String s){
        //traverse the chars of s
		//mark j as the start index of a word
		boolean hasLetter = false;
		StringBuffer sb = new StringBuffer();
		for(int i = 0, j = 0; i < s.length(); i++){
		   if(!Character.isLetterOrDigit(s.charAt(i))){
		        if(j != i){
				   if(hasLetter) {
				      reverse(s, j, i-1, sb);
					  //reset flag
					  hasLetter = false;
				   }
				   else sb.append(s.substring(j,i));
				   //forward to i to check another word
				   j = i;
				}
				sb.append(s.charAt(i));
				j++;
		   }else if(Character.isLetter(s.charAt(i))){
		        hasLetter = true;
		   }
		}
		return sb.toString();
         
     }
     
     public static void reverse(String s, int start, int end, StringBuffer sb){
        while(start <= end){
		    sb.append(s.charAt(end--));
		}
     }

     public static void main(String []args){
        System.out.println(reverse("I evah  36 skoob, 40 2snep, dna 1 koobeton."));
     }
}
