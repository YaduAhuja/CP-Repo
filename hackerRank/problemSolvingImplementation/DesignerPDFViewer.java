package hackerRank.problemSolvingImplementation;

public class DesignerPDFViewer {

    static int designerPdfViewer(int[] h, String word) {
        // ASCII a = 97
        int maxheight = 0;
        int height = 0;
        for (int i = 0; i < word.length(); i++) {

            height = h[(int) word.charAt(i) - 97];
            if (maxheight < height) {
                maxheight = height;
            }
        }
        return maxheight * word.length();
    }

    public static void main(String[] args) {
        int[] h = {
            1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5
        }; // HEight of Letters

        String w = "abc"; // Word for functions
        System.out.println(designerPdfViewer(h, w));
    }
}
