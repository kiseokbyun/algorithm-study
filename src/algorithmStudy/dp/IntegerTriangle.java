package algorithmStudy.dp;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

class IntegerTriangle {
	private static int[][] biggestSum;
    private static int depth;
    
    public int solution(int[][] triangle) {
        depth = triangle.length;
        biggestSum = new int[depth][depth];
        
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j <= i; j++) {
                biggestSum[i][j] = -1;
            }
        }
        
        return getBiggestSum(triangle, 0, 0);
    }
    
    private static int getBiggestSum(int[][] triangleBoard, int i, int j) {
        if (i == depth-1) {
            return triangleBoard[i][j];
        }

        if (biggestSum[i][j] != -1) {
            return biggestSum[i][j];
        }
        
        int result = triangleBoard[i][j] + 
            Math.max(getBiggestSum(triangleBoard, i+1, j), getBiggestSum(triangleBoard, i+1, j+1));
        
        biggestSum[i][j] = result;
        
        return result;
    }
	@Test
	void test() {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		int result = solution(triangle);
		assertThat(result, equalTo(30));
	}

}
