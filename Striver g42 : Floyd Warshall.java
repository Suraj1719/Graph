Article : https://takeuforward.org/data-structure/floyd-warshall-algorithm-g-42/

Implementation :

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=(int)(1e9);
                }
                if(i==j) matrix[i][j]=0;
            }
        }
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
            }
        }
        }
        
        //for detecting purpose of -ve cycle
        // for(int i=0;i<n;i++){
        //     if(matrix[i][i]<0) return true;//contain -ve cycle
        // }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==(int)(1e9)){
                    matrix[i][j]=-1;
                }
            }
        }
    }
}

Leet code question : 1462. Course Schedule IV

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //Floyd Warshall
        List<Boolean> ans=new ArrayList<>();
        int cost[][]=new int[numCourses][numCourses];
        for(int i=0;i<numCourses;i++){
            for(int j=0;j<numCourses;j++){
                cost[i][j]=(int)(1e9);
                if(i==j)cost[i][j]=0;
            }
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            cost[u][v]=1;
        }
        //via calling
        for(int k=0;k<numCourses;k++){
            for(int i=0;i<numCourses;i++){
                for(int j=0;j<numCourses;j++){
                cost[i][j]=Math.min(cost[i][j],cost[i][k]+cost[k][j]);
                }
            }
        }

        for(int i=0;i<numCourses;i++){
            for(int j=0;j<numCourses;j++){
                if(cost[i][j]==(int)(1e9)){
                    cost[i][j]=-1;
                }
            }
        }
        
        for(int i=0;i<queries.length;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            if(cost[u][v]==-1) ans.add(false);
            else
            ans.add(true);
        }
    return ans;
    }
}



