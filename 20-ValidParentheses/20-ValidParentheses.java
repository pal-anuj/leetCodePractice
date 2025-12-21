// Last updated: 21/12/2025, 17:22:47
class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();

        // Map<Character,Character> map= new HashMap();
        // map.put('(',')');
        // map.put('[',']');
        // map.put('{','}');
        // // List<Character> startBraces = new ArrayList();
        // // startBraces.add('(');
        // // startBraces.add('[');
        // // startBraces.add('{');
        // // List<Character> endBraces = new ArrayList();
        // //  endBraces.add(')');
        // // endBraces.add(']');
        // // endBraces.add('}');
        for(char c: s.toCharArray()){
            // if(map.containsKey(c)){
            //     stack.push(map.get(c));
            // } else {
            // // System.out.println("stack"+stack);
            // if (stack.isEmpty()) return false;
            // if(stack.pop() != c) return false;
            // }
              if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else {
                if (stack.isEmpty() || stack.pop() != c) return false;
            }

        }
        // System.out.println(stack);
        return stack.isEmpty();
        
    }
}