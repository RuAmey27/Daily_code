// learned some new functions  and there use
/*here first approach is my own which i learned from some mistakes another are others solutions for the same questions */
class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;

        while (sb.indexOf("AB") != -1 || sb.indexOf("CD") != -1) {
            if (sb.indexOf("AB") != -1) {
                int start = sb.indexOf("AB");
                int end = start + 2;
                sb = sb.delete(start, end);
            } else if (sb.indexOf("CD") != -1) {
                int start = sb.indexOf("CD");
                int end = start + 2;
                sb = sb.delete(start, end);
            }
            count++;
        }

        return sb.length();
    }
}

//
/*
 * class Solution {
    public int minLength(String s) {
     
     StringBuilder s1=new StringBuilder(s);
     while(true)   
     {
         boolean checker=true;
         for(int i=0;i<s1.length()-1;i++)
         {
             char a=s1.charAt(i);
             char b=s1.charAt(i+1);
             if((a=='A' && b=='B')||(a=='C' && b=='D')){ 
                 s1.deleteCharAt(i);
                 s1.deleteCharAt(i);
                 checker=false;
             }
         }
         if(checker) break;
     }
     return s1.length();   
    }
}
 */

 /**
  * class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        
        while (sb.indexOf("AB") != -1 && sb.indexOf("CD") != -1) {
            sb = sb.replace(sb.indexOf("AB"), sb.indexOf("AB") + 2, "x");
            sb = sb.replace(sb.indexOf("CD"), sb.indexOf("CD") + 2, "x");
            count++;
        }
        
        return count;
    }
}
  */

  /**
   * class Solution {
    public int minLength(String s) {
     while (s.contains("AB") || s.contains("CD")) {
            s = s.replaceAll("AB", "").replaceAll("CD", "");
        }
        return s.length();
    }
}
   */