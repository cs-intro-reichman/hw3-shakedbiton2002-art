// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class Anagram {
   public Anagram() {
   }

   public static void main(String[] var0) {
      System.out.println(isAnagram("silent", "listen"));
      System.out.println(isAnagram("William Shakespeare", "I am a weakish speller"));
      System.out.println(isAnagram("Madam Curie", "Radium came"));
      System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"));
      System.out.println(preProcess("What? No way!!!"));
      System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
      String var1 = "1234567";
      Boolean var2 = true;

      for(int var3 = 0; var3 < 10; ++var3) {
         String var4 = randomAnagram(var1);
         System.out.println(var4);
         var2 = var2 && isAnagram(var1, var4);
         if (!var2) {
            break;
         }
      }

      System.out.println(var2 ? "test passed" : "test Failed");
   }

   public static boolean isAnagram(String var0, String var1) {
      String var2 = preProcess(var0);
      String var3 = preProcess(var1);
      if (var2.length() != var3.length()) {
         return false;
      } else {
         int[] var4 = new int[26];

         int var6;
         int var7;
         for(int var5 = 0; var5 < var2.length(); ++var5) {
            var6 = var2.charAt(var5);
            var7 = var3.charAt(var5);
            ++var4[var6 - 97];
            --var4[var7 - 97];
         }

         int[] var9 = var4;
         var6 = var4.length;

         for(var7 = 0; var7 < var6; ++var7) {
            int var8 = var9[var7];
            if (var8 != 0) {
               return false;
            }
         }

         return true;
      }
   }

   public static String preProcess(String str) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);

        // אות גדולה -> להקטין
        if (c >= 'A' && c <= 'Z') {
            c = (char)(c + 32);
        }

        // אם זה אות קטנה -> להוסיף
        if (c >= 'a' && c <= 'z') {
            sb.append(c);
        }
       
    }

    return sb.toString();
}


   public static String randomAnagram(String var0) {
    String str1 = preProcess(var0);
    String newstr = "";
    
    // כל עוד יש תווים במחרוזת המקורית
    while (str1.length() > 0) {
        int index = (int)(Math.random() * str1.length());
        newstr = newstr + str1.charAt(index);
        str1 = str1.substring(0, index) + str1.substring(index + 1);
    }
    return newstr;

   }
}
