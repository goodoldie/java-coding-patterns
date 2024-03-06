import java.util.Arrays;

public class SortColors {
    public static int[] sortColors(int[] colorsArray) {
        try {
            if(colorsArray == null || colorsArray.length <2)
                return colorsArray;

            int red = 0, white = 0, blue = colorsArray.length - 1;

            while (white <= blue) {
                //if white is pointing to a red color, i.e, 0
                if (colorsArray[white] == 0) {
                    // Swap the values if the red pointer is not pointing to red
                    if (colorsArray[red] != 0)
                        swapColors(colorsArray, red, white);
                    // Increment both the red and white pointers
                    white++;
                    red++;
                }
                // If the white pointer is pointing to white, no swapping is required
                // Just increment the white pointer
                else if (colorsArray[white] == 1)
                    white++;
                    // If the white pointer is pointing to blue
                else {
                    //swap the pointers if blue is not pointing to 2
                    if (colorsArray[blue] != 2)
                        swapColors(colorsArray, blue, white);
                    blue--;
                }
            }
            return colorsArray;
        } catch (Exception e) {
            System.err.println("Error during sorting: " + e.getMessage());
            return colorsArray;
        }
    }
    private static void swapColors(int[] colorsArray, int pos1, int pos2){
        int temp = colorsArray[pos1];
        colorsArray[pos1] = colorsArray[pos2];
        colorsArray[pos2] = temp;
    }
    public static void main(String[] args) {
        //0 represents red
        //1 represents white
        //2 represents blue
        int[] colorsArray = {2,0,1,0,2,0,0,0,0,0,0,1};
        int[] sortedColors = sortColors(colorsArray);
        System.out.println("The sorted array is " + Arrays.toString(sortedColors));
    }
}
