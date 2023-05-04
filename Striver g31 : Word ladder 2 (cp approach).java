class Solution {

    //backtrack solution from overcome un necesary exploration
    Map<String,Integer> map;
    String b;
    List<List<String>> ans;

    void dfs(String word,List<String> seq){
        if(word.equals(b)){
            List<String> dup=new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }

        int steps=map.get(word);
        int sz=word.length();
        

        for(int i=0;i<sz;i++){
            for(char ch='a';ch<='z';ch++){
                char replaceCharArray[]=word.toCharArray();
                replaceCharArray[i]=ch;
                String replacedWord=new String(replaceCharArray);
                if(map.containsKey(replacedWord) && map.get(replacedWord)+1==steps){
                    seq.add(replacedWord);
                    dfs(replacedWord,seq);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }
    public List<List<String>> findLadders(String startWord, String targetWord, List<String> wordList) {
        
        Set<String> st=new HashSet<>();
        int len=wordList.size();
        for(int i=0;i<len;i++){
            st.add(wordList.get(i));
        }
        
        Queue<String> q=new LinkedList<>();
       
        q.add(startWord);
        b=startWord;
        map=new HashMap<>();
        map.put(startWord,1);
        int size_begin=startWord.length();
        st.remove(startWord);

        while(!q.isEmpty()){
            String word=q.peek();
            int step=map.get(word);
            q.remove(word);
            if(word.equals(targetWord)) break;

            for(int i=0;i<size_begin;i++){
                for(char ch='a';ch<='z';ch++){
                    char replaceCharArray[]=word.toCharArray();
                    replaceCharArray[i]=ch;
                    String replacedWord=new String(replaceCharArray);
                    if(st.contains(replacedWord)){
                        q.add(replacedWord);
                        st.remove(replacedWord);
                        map.put(replacedWord,step+1);
                    }
                }
            }
        }
        ans=new ArrayList<>();
        if(map.containsKey(targetWord)){
            List<String>seq=new ArrayList<>();
            seq.add(targetWord);
            dfs(targetWord,seq);
        }
    return ans;
    }
}
