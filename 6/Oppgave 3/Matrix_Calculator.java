import java.util.*;

class Matrix_Calculator {

    private static Scanner in = new Scanner(System.in);
    private static Matrix[] matrix = new Matrix[2];

    public static void main(String[]args) {
        //Asks for matrix
        while(true) {
            System.out.println("Enter your first matrix:");
            matrix[0]=Matrix.fill_matrix(create_matrix());
            System.out.println("Matrix 1:");
            print_matrix(matrix[0]);
            show_Menu();
        }
    }
//Gives menu for the user
public static void show_Menu() {
    System.out.println("Press 1 to add your matrix with another");
    System.out.println("Press 2 to multiply your matrix with another");
    System.out.println("Press 3 to transpose your matrix");
    System.out.println("Press 4 to be free from the Matrix");

int menu_input = in.nextInt();
/**
 * Switch case, based on the input from the user 
 * it gets the values from the Matrix file
 * 
 */


switch (menu_input) {

    case 1: matrix[1] = Matrix.fill_matrix(create_matrix(matrix[0].getRowAmount(), matrix[0].getColumnAmount()));
    System.out.println("Matrix 2:");
    print_matrix(matrix[1]);
    Matrix a = Matrix.addition_matrix(matrix[0], matrix[1]);
    System.out.println("Result:");
    print_matrix(a);
    break;

    case 2: System.out.println("Create matrix 2(The row amount must be the same as the first one (" + matrix[0].getRowAmount()+ "):");
        matrix[1] = Matrix.fill_matrix((create_matrix()));
        System.out.println("Matrix 2: ");
        print_matrix(matrix[1]);
        Matrix b = Matrix.multiplicate_Matrix(matrix[0], matrix[1]);
        if (b != null) {
            System.out.println("Result: ");
            print_matrix(b);
            } else {
            //If the rows arent the same it cant multiply
            System.out.println("ERROR: rows must be identical");
            }

            break;

    case 3: Matrix c = Matrix.transport_Matrix(matrix[0]);
            System.out.println("Result: ");
            print_matrix(c);
            break;


    case 4: System.out.println("You have escaped the Matrix");
            System.exit(0);
    
    //This is for when the input is not valid
    default: System.out.println("Your input must be between 1 and 4");
            show_Menu();
            break;
    }
}

    //Creates the matrix using the inputs from the user
    public static double[][] create_matrix() {

        System.out.println("Print row amount: "); int row = in.nextInt();
        System.out.println("Print coloumn amount: "); int column = in.nextInt();
        double[][]m= new double[row][column];
        //Asks for the numbers inside the matrix
        System.out.println("Fill your matrix: ");
        for(int i =0; i < row; i++) {
            for(int p = 0; p < column; p++) {
                System.out.println("[" + i + "]" + "[" + p + "]: ");
                m[i][p]= in.nextDouble();
            }
        }

        return m;
    }

    public static double[][] create_matrix(int row, int column) {
        double[][]m = new double[row][column];

        System.out.println("Enter the matrix: ");
        for(int i = 0; i < row; i++) {
            for(int p = 0; p < column; p++) {
              System.out.print("[" + i + "]" + "[" + p + "]: ");
              m[i][p] = in.nextDouble();       
            }

        }
    return m;
    }

    public static void print_matrix(Matrix m) {

        int row= m.getRowAmount();
        int column = m.getColumnAmount();
        double[][] t = m.get_matrix();

        for (int i = 0; i < row; i++) {
            String rad = "";
            for (int j = 0; j < column; j++) {
              rad+= t[i][j] + " ";
        }

        System.out.println(rad);
        }
    }

}