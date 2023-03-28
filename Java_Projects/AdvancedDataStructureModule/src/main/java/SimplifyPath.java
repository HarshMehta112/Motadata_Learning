import java.util.Stack;

class SimplifyPath {
    public String simplifyPath(String path) {

        String[] s = path.split("/");

        Stack<String> st = new Stack<String>();

        for(String str:s)
        {
            if(str.equals(".."))
            {
                if(!st.isEmpty())
                {
                    st.pop();
                }
            }
            else if(str.equals(".") || str.equals("") || str.equals(" "))
            {
                continue;
            }
            else
            {
                st.push("/"+str);
            }
        }

        String ans = new String();

        while(!st.isEmpty())
        {
            ans=st.pop()+ans;
        }

        if(ans.equals("")) return "/";
        return ans;


    }
}