/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
  public int getImportance(List<Employee> employees, int id, HashMap<Integer, Employee> m){
        Employee emp = m.get(id);
        
        int ans = emp.importance;
        
        int id2;
        
        for (int i = 0 ; i < emp.subordinates.size(); i++){
            id2 = emp.subordinates.get(i);
            
            ans += getImportance(employees, m.get(id2).id, m);
        }
        
        return ans;
    }
    
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> m = new HashMap<>();
        
        for (int i = 0; i < employees.size(); i++){
            m.put(employees.get(i).id, employees.get(i));
        }
        
        return getImportance(employees, id, m);
    }
}