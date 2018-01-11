package testString;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String [] args){
        String s = "\"" + "South Park: Bigger, longer & uncut" +  "\"" + " 30 " + "9 " +  "\"" +
        "israel" +  "\"" + " " +  "\"" + "iran " +  "\"";
        List<String> list = splitString(s);
        list.forEach(as->{
            System.out.println(as);
        });
    }
    public static List<String> splitString(String message){
        String msg = message;
        List<String> list = new ArrayList<>();
        Matcher m = Pattern.compile("(\\w+)|\"(.*?)\"").matcher(msg);
        while (m.find())
            list.add(m.group(0).replace("\"","" ));
        return list;
    }
}
