public class FirstBadVersion {
    public static int firstBadVersion = 6;
    private static boolean isBadVersion(int version){
        return version >= firstBadVersion;
    }
    public static int[] findFirstBadVersion(int n){
        int[] result = new int[2];
        int left = 1;
        int right = n;
        int comparison = 0;
        while(left < right){
            int middle = left + (right - left) / 2;
            if(isBadVersion(middle))
                right = middle;
            else
                left = middle + 1;
            comparison += 1;
        }
        result[0] = left;
        result[1] = comparison;
        return result;
    }
    public static void main(String[] args) {
        int n = 8;
        int[] versionControlResult = findFirstBadVersion(n);
        System.out.println("The first bad version is " + versionControlResult[0] + " found in " + versionControlResult[1] + " comparisons");
    }
}
