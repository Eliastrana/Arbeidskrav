import java.util.*;

public class Matrix {

    private final double[][] m;
    private Matrix(double[][] n) {
        m = n;
    }

    public static Matrix fill_matrix(double[][] n) {
        return new Matrix(n);
    }

    public double [][] get_matrix() {
        return m;
    }

    //Addition matrix, adding each of the values with eachother
    public static Matrix addition_matrix (Matrix matrix1, Matrix matrix2) {
        int row = matrix1.getRowAmount();
        int column = matrix1.getColumnAmount();
        double [][] n = new double [row] [column];
        for (int i = 0; i < row; i++) {
            for (int p = 0; p < column; p++) {

                n[i][p]= matrix1.m[i][p] + matrix2.m[i][p];

            }
        }
        return new Matrix(n);
    }
    //This multiplies the matrixes with each other
    public static Matrix multiplicate_Matrix(Matrix a, Matrix b) {
        int row_A = a.get_matrix().length;
        int column_A = a.get_matrix()[0].length;
        int row_B = b.get_matrix().length;
        int column_B= b.get_matrix()[0].length;

        if (column_A == row_B) {
            double[][] n = new double[row_A][column_B];
            for(int i =0; i < column_B; i++) {
                for(int p=0; p < row_A; p++) {
                    for(int u = 0; u <column_A; u++) {
                        n[p][i]=n[p][i] + a.get_matrix()[p][u]*b.get_matrix()[u][i];
                    }
                }
            }
            return new Matrix(n);
            } else {
            return null;
            }
        }
        //This swaps the top right with the bottom left in a 2x2 matrix, and so on
        public static Matrix transport_Matrix(Matrix a) {
            int row = a.get_matrix().length;
            int column = a.get_matrix()[0].length;
            double[][]n=new double [column][row];
            for(int i = 0; i<row; i++) {
                for (int p = 0; p <column; p++) {
                    n[p][i]= a.get_matrix()[i][p];
                }
            }
            return new Matrix(n);
        }

        //creates public in row
        public int getRowAmount() {
            int row = m.length;
            return row;
        }
        //creates public in row
        public int getColumnAmount(){
            int column = m[0].length;
            return column;
        }
    }


