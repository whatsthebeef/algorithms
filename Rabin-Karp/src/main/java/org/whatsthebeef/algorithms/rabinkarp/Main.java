package org.whatsthebeef.algorithms.rabinkarp;

public class Main {

   /**
    * in this case ascii which has 256 possible chars
    */
   private static final double TOTAL_NUMBER_OF_CHARS_POSSIBLE = 256;

   public static void main(String[] args) {
      String contentString = "";
      String searchString = "";

      if (args.length == 2) {
         contentString = args[0];
         searchString = args[1];
      } else {
         System.out.println("you are missing arguments");
      }

      double contentStringLength = contentString.length();
      double searchStringLength = searchString.length();

      // hash sub string
      double hashedSearchString = createStringHash(searchString,
            searchStringLength);

      double hashedContentString = createStringHash(
            contentString.substring(0, (int) searchStringLength),
            searchStringLength);

      System.out.println("hashed search string is: " + hashedSearchString);
      for (int pos = 0; pos <= (contentStringLength - (searchStringLength)); pos++) {
         System.out.println("hashed content string at position " + pos
               + " is: " + hashedContentString);
         if (hashedContentString == hashedSearchString) {
            System.out.println("Found String at pos: " + pos
                  + ", hash is: " + hashedContentString);
            break;
         }
         if (contentStringLength > (pos + searchStringLength)) {
            System.out.println("update hash");
            hashedContentString = TOTAL_NUMBER_OF_CHARS_POSSIBLE
                  * (hashedContentString - (Math.pow(
                        TOTAL_NUMBER_OF_CHARS_POSSIBLE,
                        (searchStringLength - 1)) * ((double) contentString
                        .charAt(pos))))
                  + contentString.charAt(pos + (int) searchStringLength);
         }
      }
   }

   /**
    * Gets passed a string and creates a hash
    * 
    * @param aString
    *            , the string to hash
    * 
    * @return hashed String
    */
   public static double createStringHash(String aString,
         double aSearchStringLength) {
      double hashedString = 0;
      // cycles through string creating a hash value from each char
      for (int pos = 0; pos < aString.length(); pos++) {
         // add values up
         hashedString += createCharHash(aString, pos, aSearchStringLength);
      }
      return hashedString;
   }

   /**
    * Creates hash of char from string and position of char in question
    * 
    * @param aString
    *            , the string containing the char to be hashed
    * @param aPosition
    *            , the position of the char to be hashed
    * @param
    * 
    * @return hashed Char
    */
   public static double createCharHash(String aString, double aPosition,
         double aSearchStringLength) {
      return (Math.pow(TOTAL_NUMBER_OF_CHARS_POSSIBLE,
            (aSearchStringLength - (aPosition + 1))) * ((double) aString
            .charAt((int) aPosition)));
   }
}
