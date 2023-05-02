//LeetCode : 127. Word Ladder  Hard

//Article : https://takeuforward.org/graph/word-ladder-i-g-29/

//code : 

class Solution {

    class Pair{
        String first;
        int second;
        Pair(String first,int second){
            this.first=first;
            this.second=second;
        }
    }

    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(startWord,1));
        
        Set<String> s=new HashSet<>();
        int len=wordList.size();
        for(int i=0;i<len;i++){
            s.add(wordList.get(i));
        }
        
        //we remove taken or visited word from set so than we do not end up in a loop
        s.remove(startWord);
        
        while(!q.isEmpty()){
            String word=q.peek().first;
            int step=q.peek().second;
            q.remove();
            
            //if this is the targetWord , we return step as it is the minimum step
            if(word.equals(targetWord)){
                return step;
            }
            //we try to find all posible word by replace in character in every position
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedCharArray[]=word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedString=new String(replacedCharArray);
                    
                    if(s.contains(replacedString)){
                        q.add(new Pair(replacedString,step+1));
                        s.remove(replacedString);
                    }
                }
            }
        }
        
    return 0;//if we do not get target word
    }
}
