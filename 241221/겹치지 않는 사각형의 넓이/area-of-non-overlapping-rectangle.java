import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rectA = parseRectangleInput(br);
        int[] rectB = parseRectangleInput(br);
        int[] rectM = parseRectangleInput(br);

        // 좌표 정렬
        rectA = normalizeRectangle(rectA);
        rectB = normalizeRectangle(rectB);
        rectM = normalizeRectangle(rectM);

        // 영역 계산
        int areaA = calculateArea(rectA);
        int areaB = calculateArea(rectB);

        // M과 겹치는 넓이 계산
        int overlapA = calculateOverlap(rectA, rectM);
        int overlapB = calculateOverlap(rectB, rectM);

        // 겹치지 않는 넓이 계산
        int remainingArea = (areaA - overlapA) + (areaB - overlapB);

        System.out.println(remainingArea);

    }

    private static int calculateOverlap(int[] rect, int[] rectM) {
        int xOverlap = Math.max(0, Math.min(rect[2], rectM[2]) - Math.max(rect[0], rectM[0]));
        int yOverlap = Math.max(0, Math.min(rect[3], rectM[3]) - Math.max(rect[1], rectM[1]));
        return xOverlap * yOverlap;
    }

    public static int calculateArea(int[] rect) {
        return (rect[2] - rect[0]) * (rect[3] - rect[1]);
    }

    private static int[] normalizeRectangle(int[] rect) {
        int x1 = Math.min(rect[0], rect[2]);
        int y1 = Math.min(rect[1], rect[3]);
        int x2 = Math.max(rect[0], rect[2]);
        int y2 = Math.max(rect[1], rect[3]);
        return new int[]{x1, y1, x2, y2};
    }

    private static int[] parseRectangleInput(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int[] coordinates = new int[4];
        for (int i = 0; i < 4; i++) {
            coordinates[i] = Integer.parseInt(input[i]);
        }
        return coordinates;
    }
}