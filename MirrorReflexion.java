// There is a special square room with mirrors on each of the four walls.  Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.

// The square room has walls of length p, and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.

// Return the number of the receptor that the ray meets first.  (It is guaranteed that the ray will meet a receptor eventually.)

// https://leetcode.com/problems/mirror-reflection/



class Solution {
    public int mirrorReflection(int p, int q) {
        int ext=q, ref=p;
        while(ext%2==0 && ref%2 ==0){
            ext=ext/2;
            ref=ref/2;
        }
        
        if(ext%2==0 && ref%2==1){
            return 0;
        }
        if(ext%2==1 && ref%2==1){
            return 1;
        }
        if(ext%2==1 && ref%2==0){
            return 2;
        }
        return -1;
    }
}