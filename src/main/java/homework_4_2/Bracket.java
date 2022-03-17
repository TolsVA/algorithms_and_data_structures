package homework_4_2;




public class Bracket {
    private String input;

    public Bracket(String in){
        input = in;
    }
    public void check() {
        int size = input.length();
        Stack st = new Stack(size);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '[':
                case '{':
                case '(':
                    st.push(ch);
                    break;
                case ']':
                case '}':
                case ')':
                    if (!st.isEmpty()) {
                        char chr = st.pop();
                        if ((ch == '}' && chr != '{') || (ch == ']' && chr != '[') || (ch == ')' && chr != '(')) {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    } else {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                    break;
                default:
                    break;
            }
        }
        if (!st.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}