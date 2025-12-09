public class TokyoMap {
    private String[] siteCode = {"A", "B", "C", "D", "E", "F", "G"};
    private String[] siteName = {"Shibuya Crossing","Meiji Shrine","Tokyo Tower","Akihabara","Senso-Ji Temple","Ueno Park","Tokyo Skytree"};
    private int[] x = {3, 4, 5, 8, 9, 6, 11};
    private int[] y = {7, 1, 3, 8, 7, 2, 2};
    
    private int[][] dist = new int[7][7];
    public void Map() {
        dist[0][1] = 4; dist[1][0] = 4;
        dist[1][2] = 3; dist[2][1] = 3;
        dist[0][5] = 2; dist[5][0] = 2;
        dist[5][4] = 2; dist[4][5] = 2;
        dist[4][6] = 6; dist[6][4] = 6;
        dist[2][6] = 5; dist[6][2] = 5;
        dist[5][3] = 3; dist[3][5] = 3;
        dist[3][6] = 4; dist[6][3] = 4;
    }

		private void menu(){
			int choice = sc.nextInt();
			do{
				switch(choice){
					case 1 -> search();
					case 2 -> insert();
					case 3 -> allCons();
					case 4 -> closest();
				}
			}while(choice != 0)
		}
    
    private int search(String searchIndex) {
        for (int i = 0; i < 7; i++) {
            if (siteCode[i].equals(searchIndex) || siteName[i].equals(searchIndex)) {
                System.out.println("Found " + siteCode[i] + "  " + siteName[i]);
                System.out.println("Coordinates (" + x[i] + "" + y[i] + ")");
                return i;
            }
        }
        System.out.println("Site not found");
        return -1;
    }
    
    private void Insert(int i, int j, int distance) {
        if (i >= 0 && i < 7 && j >= 0 && j < 7) {
            dist[i][j] = distance;
            dist[j][i] = distance;
            System.out.println("Connection added " + distance + "KM");
        }
    }
    
    private void AllCons(int i) {
        if (i >= 0 && i < 7) {
            System.out.println("Connections from " + siteName[i] + " ");
            for (int j = 0; j < 7; j++) {
                if (dist[i][j] > 0) {
                    System.out.println(siteName[i] + "  " + siteName[j] + ": " + dist[i][j] + "KM");
                }
            }
        }
    }
    private int Closest(int i) {
        if (i >= 0 && i < 7) {
            int minDistance = 999;
            int closestIndex = -1;
            for (int j = 0; j < 7; j++) {
                if (dist[i][j] > 0 && dist[i][j] < minDistance) {
                    minDistance = dist[i][j];
                    closestIndex = j;
                }
            }
            if (closestIndex != -1) {
                System.out.println("Closest " + siteName[closestIndex] + " at the distance of " + minDistance + "KM");
            }
            return closestIndex;
        }
        return -1;
    }
    
    
