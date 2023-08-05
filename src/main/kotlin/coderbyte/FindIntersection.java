package coderbyte;


/**
 * Have the function FindIntersection(strArr) read the array of strings
 * stored in strArr which will contain 2 elements: the first element will
 * represent a list of comma-separated numbers sorted in ascending order,
 * the second element will represent a second list of comma-separated numbers
 * (also sorted). Your goal is to return a comma-separated string containing
 * the numbers that occur in elements of strArr in sorted order.
 * If there is no intersection, return the string false.
 *
 *
 * My solution is O(n). The rule cases where simple enough, however the complexity here came from managing the pointers correctly
 * at the end of lists. I could probably shorten this to be less verbose.
 *
 * Another solution uses hashmaps for O(n).
 */
public class FindIntersection {

    public static String findIntersection(String[] strArr) {
        // code goes here

        // converting string into array of strings.
        String[] list1 = strArr[0].split(", ");
        String[] list2 = strArr[1].split(", ");

        int list1Index = 0;
        int list2Index = 0;

        StringBuilder strBuilder = new StringBuilder(100);

        while (list1Index < list1.length && list2Index < list2.length) {

            int num1 = Integer.parseInt(list1[list1Index]);
            int num2 = Integer.parseInt(list2[list2Index]);

            // case 1: number at indexes are equal.
            if (num1 == num2) {

                strBuilder.append(list1[list1Index]).append(", ");

                list1Index++;
                list2Index++;

                continue;
            }

            // case 2: number at list 1 is greater than list 2,
            if (num1 > num2) {

                if (list2Index < list2.length - 1) {
                    list2Index++;
                } else {
                    list1Index++;
                }

                continue;
            }

            // case 3: number at list 2 is greater than list 1.
            if (list1Index < list1.length - 1) {
                list1Index++;
            } else {
                list2Index++;
            }

        }

        if (strBuilder.length() != 0) {
            strBuilder.deleteCharAt(strBuilder.length() - 1);
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        } else {
            strBuilder.replace(0, 0, "false");
        }

        return strBuilder.toString();
    }
}
