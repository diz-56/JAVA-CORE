import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//вариант проверки на наличие в массиве элемента с неверным значением
        String[][] arr = new String[][]{{"11", "11", "11", "11"}, {"22", "22", "22", "22"}, {"33", "33", "33", "33"}, {"44", "44", "b", "44"}};

//вариант проверки на размерность массива отличную от 4х4
//        String[][] arr = new String[][]{{"11", "11", "11", "11", "11"}, {"22", "22", "22", "22"}, {"33", "33", "33", "33"}, {"44", "44", "44", "44"}};
try {
  try {
   int result = MyMetod(arr);
    System.out.println(result);
        } catch (MyArraySizeException Exc) {
                System.out.println("Размер массива не соответствует условию задачи!");
          }
        }
       catch (MyArrayDataException Exc) {
           System.out.println("В массиве присутствуют неверные данные");
           System.out.println("Ошибка в ячейке: " + Exc.i + "x" + Exc.j);
      }

    }

    public static int MyMetod(String[][] arr) throws MyArraySizeException, MyArrayDataException {
       int myCounter = 0;
       if (arr.length != 4) {
           throw new MyArraySizeException();
       }
      for (int i = 0; i < arr.length; i++) {
           if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    myCounter = myCounter + Integer.parseInt(arr[i][j]);
               }
                catch (NumberFormatException Exc) {
                    throw new MyArrayDataException(i, j);
               }
            }

        }
        return myCounter;
   }

}
