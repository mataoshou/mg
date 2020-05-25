package build.tool;

public class StringUtil {

    public static String firstUpper(String str)
    {
        char first = Character.toUpperCase(str.charAt(0));
        StringBuffer methodName = new StringBuffer(str);
        methodName.setCharAt(0, first);

        return methodName.toString();
    }

    public static String connect(String s1,String s2,String intrerval)
    {
        return s1 + intrerval + s2;
    }

    public static String addUnEmpty(String str ,String pre,String last)
    {
        if(isEmpty(str)) return "";
        if(!isEmpty(pre))str = pre+str;
        if(!isEmpty(last))str = str +last;

        return str;
    }

    public static boolean isEmpty(String str)
    {
        return str==null||str.length()==0;
    }
}
