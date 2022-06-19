class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
       
         HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        // Now preprocessing has to be done 
        for(int i=0;i<routes.length;i++)
        {
            for(int j=0;j<routes[i].length;j++)
            {
                int busstopno=routes[i][j];
                ArrayList<Integer> busno= map.getOrDefault(busstopno, new ArrayList<>());
                busno.add(i);
                map.put(busstopno, busno);
                
            }
        }
        HashSet<Integer> busstopvis= new HashSet<>();
        HashSet<Integer> busnovis= new HashSet<>();
        queue.add(source);// it contains all the busstop
        busstopvis.add(source);
        
        int level=0;
        while(queue.size()>0)
        {
            int size= queue.size();
            
            while(size-->0)
            {
                
                int rem =queue.remove();
                if(rem ==target)
                {
                    return level;
                }
    
                ArrayList<Integer> buses = map.get(rem);
                for(int bus: buses)
                {
                    if(busnovis.contains(bus))
                    {
                        continue;
                    }
                    busnovis.add(bus);
                    int arr[]=routes[bus];
                    
                    for(int busstop : arr)
                    {
                       if(busstopvis.contains(busstop)) 
                       {
                           continue;
                       }
                        
                        queue.add(busstop);
                        busstopvis.add(busstop);
                    }    
                    
                }
                
            }
            level++;
        }
        
        return -1;
    }
}