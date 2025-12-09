import java.util.Scanner;
public class Tokyo{
    private String[] siteCode = {"A", "B", "C", "D", "E", "F", "G"};
    private String[] siteName = {"Shibuya Crossing","Meiji Shrine","Tokyo Tower","Akihabara","Senso-Ji Temple","Ueno Park","Tokyo Skytree"};
    private int[] x = {3, 4, 5, 8, 9, 6, 11};
    private int[] y = {7, 1, 3, 8, 7, 2, 2};
		static Scanner sc = new Scanner(System.in);
    
    private int[][] dist = new int[7][7];

		public Tokyo(){
			initMap();
		}

    public void initMap() {
        dist[0][1] = 4; dist[1][0] = 4;
        dist[1][2] = 3; dist[2][1] = 3;
        dist[0][5] = 2; dist[5][0] = 2;
        dist[5][4] = 2; dist[4][5] = 2;
        dist[4][6] = 6; dist[6][4] = 6;
        dist[2][6] = 5; dist[6][2] = 5;
        dist[5][3] = 3; dist[3][5] = 3;
        dist[3][6] = 4; dist[6][3] = 4;
    }

		public void start(){
			menu();
		}

		private void menu(){
			int choice = 0;
			do{
					System.out.println("----------------------------------------");
					System.out.println("1. Search");
					System.out.println("2. Insert");
					System.out.println("3. All Conections");
					System.out.println("4. Closest");
					System.out.println("0. Exit");
					System.out.print("Enter a choice: ");
				 	choice = sc.nextInt();
					System.out.println("----------------------------------------");
				switch(choice){
					case 1 -> doSearch();
					case 2 -> doInsert();
					case 3 -> doAllCons();
					case 4 -> doClosest();
				}
			}while(choice != 0);
		}//end menu()
    
		//-------------------------------------------------------------------------------------------------//

		private void doSearch(){
			sc.nextLine();
			System.out.print("Enter search index: ");
			String searchIndex = sc.nextLine();
			search(searchIndex);
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
		//-------------------------------------------------------------------------------------------------//
    private void doInsert(){
			sc.nextLine();
			System.out.print("Enter x: ");
			int i = sc.nextInt();
			System.out.print("Enter y: ");
			int j = sc.nextInt();
			System.out.print("Enter Distance: ");
			int distance = sc.nextInt();
			insert(i, j, distance);
		}
    private void insert(int i, int j, int distance) {
        if (i >= 0 && i < 7 && j >= 0 && j < 7) {
            dist[i][j] = distance;
            dist[j][i] = distance;
            System.out.println("Connection added " + distance + "KM");
        }
    }
		//-------------------------------------------------------------------------------------------------//
    
		private void doAllCons(){
				sc.nextLine();
				System.out.print("Enter x: ");
				int x = sc.nextInt();
				allCons(x);
		}
    private void allCons(int i) {
        if (i >= 0 && i < 7) {
            System.out.println("Connections from " + siteName[i] + " ");
            for (int j = 0; j < 7; j++) {
                if (dist[i][j] > 0) {
                    System.out.println(siteName[i] + "  " + siteName[j] + ": " + dist[i][j] + "KM");
                }
            }
        }
    }
		//-------------------------------------------------------------------------------------------------//
		private void doClosest(){
			sc.nextLine();
			System.out.print("Enter x: ");
			int x = sc.nextInt();
			closest(x);
		}
    private int closest(int i) {
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
}//end class
    
