package stringpractice;

public class StringTest3 {
    public static void main(String[] args) {
        String str1 = "As the sun dipped below the horizon, painting the sky in hues of orange and pink," +
                " a sense of serenity washed over the tranquil seaside village of Polppero.";

        String str2 = "as the sun dipped below the horizon, painting the sky in hues of orange and pink," +
                " a sense of serenity washed over the tranquil seaside village of polppero.";


        System.out.println("str1 equals str2 = " + str1.equals(str2));
        System.out.println("str1 equalsIgnoreCase str2 = " + str1.equalsIgnoreCase(str2));

        System.out.println("'banana' compareTo 'apple' = " + "banana".compareTo("apple"));

        System.out.println("str1 starts with 'As' = " + str1.startsWith("As"));
        System.out.println("str1 ends with 'polperro.' = " + str1.endsWith("polperro."));
    }
}

