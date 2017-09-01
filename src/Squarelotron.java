
public class Squarelotron {
	public int[][] squarelotron;
	public int size;
	
	/**
	 * This method constructs a new Squarelotron (2D int array) with dimensions n x n 
	 * or int[n][n] and initializes the values of starting at [0][0] with 1 and ends 
	 * at [n][n] with the value of n*n.
	 * @param n is the dimension of the 2D array.  There are n rows and n columns.
	 */
	public Squarelotron (int n){
		this.size = n;
		this.squarelotron = new int[size][size]; 
		
		int count = 1;
		for (int i=0; i<size; i++){
			for (int j=0; j<size; j++){
				squarelotron[i][j] = count;
				count++;
			}
		}
	}
	/**
	 * 
	 * @param ring
	 * @return Returns a new Squarelotron.
	 */
	public Squarelotron upsideDownFlip(int ring){
		Squarelotron flipped = new Squarelotron(size);
		
		//top row to bottom row
		for (int j = (ring-1); j <= (size - ring); j++){
			flipped.squarelotron[ring-1][j] = squarelotron[(size - ring)][j];
			flipped.squarelotron[(size - ring)][j] = squarelotron[ring-1][j];
		}
		// sides
		for(int i = ring; i < (size/(ring+1)); i++){
			//left side
			flipped.squarelotron[i][ring-1] = squarelotron[(size-i-1)][ring-1];
			flipped.squarelotron[(size-i-1)][ring-1] = squarelotron[i][ring-1];
			//right side
			flipped.squarelotron[i][size-ring] = squarelotron[(size-i-1)][size-ring];
			flipped.squarelotron[(size-i-1)][size-ring] = squarelotron[i][size-ring];
		}
		return flipped;
	}
	
	public Squarelotron mainDiagonalFlip(int ring){
		Squarelotron flipped = new Squarelotron(size);
		
		//top row to side column
		for (int j = (ring-1); j <= (size - ring); j++){
			flipped.squarelotron[ring-1][j] = squarelotron[j][ring-1];
			flipped.squarelotron[j][ring-1] = squarelotron[ring-1][j];
		}
		// side column to bottom row
		for (int i = (ring); i<= (size-ring-1); i++){
			flipped.squarelotron[size-ring][i] = squarelotron[i][size-ring];
			flipped.squarelotron[i][size-ring] = squarelotron[size-ring][i];
		}

		return flipped;
	}
	
	public void rotateRight(int numberOfTurns){
		
		int actualTurns = 0;
		// no change if full rotation
		if (numberOfTurns > 0){
			actualTurns = numberOfTurns % 4;
		} else if (numberOfTurns < 0){
			actualTurns = 4 - ((numberOfTurns % 4) * (-1)); // same as actualTurns = numbersTurns (mod) 4
		} else{
			return;	// numberOfTurns = 0
		}
		
		int[][] copy = new int[size][size];
		int count;
	
		
		while (actualTurns != 0){
			// copy array
			for (int i = 0; i < size; i++){
				for (int j = 0; j < size; j++){
					copy[i][j] = squarelotron[i][j];
				}
			}

			// update squarelotron
			for (int i = 0; i < size; i++){
				count = size - 1;
				for (int j = 0; j < size; j++){
					switch(i){
						case 0:
							squarelotron[i][j] = copy[count][0];
							count--;
							break;
						case 1:
							squarelotron[i][j] = copy[count][1];
							count--;
							break;
						case 2:
							squarelotron[i][j] = copy[count][2];
							count--;
							break;
						case 3:
							squarelotron[i][j] = copy[count][3];
							count--;
							break;
						case 4:
							squarelotron[i][j] = copy[count][4];
							count--;
							break;
						case 5:
							squarelotron[i][j] = copy[count][5];
							count--;
							break;
						case 6:
							squarelotron[i][j] = copy[count][6];
							count--;
							break;
						case 7:
							squarelotron[i][j] = copy[count][7];
							count--;
							break;
						default:
							System.out.println("error");
							break;
					}
				}
			}
		actualTurns--;
		}
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testsize = 3;
		Squarelotron s = new Squarelotron(testsize);
		for (int i=0; i<testsize; i++){
			for (int j=0; j<testsize; j++){
				System.out.print(" " + s.squarelotron[i][j] + " ");
			}
			System.out.print("\n");
		}
		
		System.out.println("size = " + s.size);
		System.out.println("size = " + s.squarelotron.length);
		System.out.print("\n");
		
		//s.rotateRight(-1);
		
		Squarelotron flip = new Squarelotron(testsize).upsideDownFlip(1);
		
		for (int i=0; i<testsize; i++){
			for (int j=0; j<testsize; j++){
				System.out.print(" " + flip.squarelotron[i][j] + " ");
			}
			System.out.print("\n");
		}
		
		System.out.print("\n");
		
		for (int i=0; i<testsize; i++){
			for (int j=0; j<testsize; j++){
				System.out.print(" " + s.squarelotron[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("size = " + s.size);
		System.out.println("size = " + s.squarelotron.length);
		System.out.print("\n");

	}

}
