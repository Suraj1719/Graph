package graphStriver;

import java.util.*;
public class g30WordLader2LC126 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String startWord = "der", targetWord = "dfs",
				wordList[] = {"des","der","dfr","dgt","dfs"};
		ArrayList<ArrayList<String>> res=findSequences(startWord,targetWord,wordList);
		for(ArrayList<String> x: res) {
			System.out.println(x);
    }


	}
	public static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        
        Set<String> st=new HashSet<>();
        int len=wordList.length;
        for(int i=0;i<len;i++){
            st.add(wordList[i]);
        }
        
        Queue<ArrayList<String>> q=new LinkedList<>();
        ArrayList<String> first=new ArrayList<>();
        first.add(startWord);
        q.add(first);
        
        ArrayList<String> usedOnlevel=new ArrayList<>();
        usedOnlevel.add(startWord);
        
        int level=0;
        
        
        while(!q.isEmpty()){
            ArrayList<String> cur=q.peek();
            q.remove();
            
            //delete all word from set that used in last level
            if(cur.size()>level){
                level++;
                for(String s:usedOnlevel){
                    st.remove(s);
                }
            }
            
            String last_word=cur.get(cur.size()-1);
            
            if(last_word.equals(targetWord)){
                //if it is the first sequence
                if(ans.size()==0) ans.add(cur);
                else if(ans.get(0).size()==cur.size()) ans.add(cur);
            }
            
            for(int i=0;i<last_word.length();i++){
                for(char c='a';c<='z';c++){
                    char replacedCharArray[]=last_word.toCharArray();
                    replacedCharArray[i]=c;
                    String replacedWord=new String(replacedCharArray);
                    
                    if(st.contains(replacedWord)){
                        cur.add(replacedWord);
//as java is work on reference , so we copy cur to new list and store list into queue
                        ArrayList<String> temp=new ArrayList<>(cur);
                        q.add(temp);
                        usedOnlevel.add(replacedWord);
                        cur.remove(cur.size()-1);//as we have to explore all poss. sequ.
                    }
                }
            }
        }
    return ans;
    }

}
