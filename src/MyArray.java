import java.util.*;
public class MyArray {
    public int efficientTravel(int[] arr, int initialEnergy) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        int i = 0;
        int energy = initialEnergy;
        while (i < arr.length && energy > arr[i]) {
            energy = energy - arr[i];
            i++;
        }
        return i - 1;
    }

    public int sumPrefixSuffix(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int prefix = 0;
            for (int k = i + 1; k < arr.length; k++) {
                prefix = prefix + arr[k];
            }
            int suffix = 0;
            for (int k = i - 1; k >= 0; k--) {
                suffix = suffix + arr[k];
            }

            if (suffix == prefix) {
                return i;
            }
        }
        return -1;
    }

    public int minFlips(int[] arr) {
        int zero = 0;
        int one = 0;
        for (int value : arr) {
            if (value == 1) {
                one++;
            } else {
                zero++;
            }
        }
        return Math.min(one, zero);
    }

    public int oneOut(int[] arr) {
        int value = 0;
        for (int j : arr) {
            value = value ^ j;
        }
        return value;
    }

    public boolean isPair(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == k) {
                return true;
            } else if (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public int miniPainter(int[] arr) {
        int max = 0;
        for (int j : arr) {
            max = Math.max(j, max);
        }

        int time = 0;
        for (int j : arr) {
            if (j == max)
                continue;
            time = time + j;
        }
        return time;
    }

    static class Point {
        float x;
        float y;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float distance(Point other) {
            float dx = x - other.x;
            float dy = y - other.y;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }

        public void translate(float dx, float dy) {
            x += dx;
            y += dy;
        }

        public String display() {
            System.out.println("(" + x + ", " + y + ")");
            return "(" + x + ", " + y + ")";
        }
    }

    abstract class Shape {
        public float getArea() {
            return 0;
        }
    }

    class Circle extends Shape {
        private float radius;

        public Circle(float r) {
            radius = r;
        }

        @Override
        public float getArea() {
            return (float) (3.14159 * radius * radius);
        }
    }

    class Square extends Shape {
        private float side;

        public Square(float s) {
            side = s;
        }

        @Override
        public float getArea() {
            return side * side;
        }
    }

    class GeometryOperations {
        public void performOperations() {
            UserError error = new UserError();
            Scanner userInput = new Scanner(System.in);

            System.out.println("Enter coordinates of first Point ");
            float x1;
            while (true) {
                System.out.print("Enter x1 coordinates :- ");
                try {
                    x1 = Float.parseFloat(userInput.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(error.errorInput);
                }
            }

            float y1;
            while (true) {
                System.out.print("Enter y1 coordinates :- ");
                try {
                    y1 = Float.parseFloat(userInput.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(error.errorInput);
                }
            }

            System.out.println("Enter coordinates of second Point ");
            float x2;
            while (true) {
                System.out.print("Enter x2 coordinates :- ");
                try {
                    x2 = Float.parseFloat(userInput.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(error.errorInput);
                }
            }

            float y2;
            while (true) {
                System.out.print("Enter y2 coordinates :- ");
                try {
                    y2 = Float.parseFloat(userInput.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(error.errorInput);
                }
            }

            float radius;
            while (true) {
                System.out.print("Enter radius of the circle: ");
                try {
                    radius = Float.parseFloat(userInput.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(error.errorInput);
                }
            }

            float side;
            while (true) {
                System.out.print("Enter side length of the square: ");
                try {
                    side = Float.parseFloat(userInput.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(error.errorInput);
                }
            }

            System.out.print("Enter translation values (x3, y3) for Point 1: ");
            float x3;
            while (true) {
                System.out.print("Enter x3 value ");
                try {
                    x3 = Float.parseFloat(userInput.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(error.errorInput);
                }
            }
            float y3;
            while (true) {
                try {
                    System.out.println("Enter y3 value : ");
                    y3 = Float.parseFloat(userInput.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(error.errorInput);
                }
            }

            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);
            Circle c = new Circle(radius);
            Square sq = new Square(side);

            System.out.println("Distance between points:- " + p1.distance(p2));
            System.out.println("Circle Area:- " + c.getArea());
            System.out.println("Square Area:- " + sq.getArea());

            p1.translate(x3, y3);
            System.out.print("Translated Point 1: ");
            System.out.println(p1.display());
        }
    }


    public static void main(String[] args) {
        MyArray task = new MyArray();
        UserError error = new UserError();
        Scanner userInput = new Scanner(System.in);
        String details = """
                1. The Efficient Traveler
                2. The Sum That Stands Out
                3. Flip the Switch
                4. The Odd One Out
                5. Smart Pair Finder
                6. The Minimalist Painter
                7. The Geometry Hierarchy
                8. Exit........
                """;
        while (true) {
            System.out.println(details);
            System.out.print("Select task between 1 to 8 :- ");
            int choice;
            while (true) {
                String number = userInput.nextLine();
                try {
                    choice = Integer.parseInt(number);
                    if (choice >= 1 && choice <= 8) {
                        break;
                    } else {
                        System.out.print("Enter a number between 1 and 8: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print(error.errorInput);
                }
            }
            if (choice == 8) {
                System.out.println("Shukriyaa ? ");
                break;
            }
            int size = 0;
            if (choice < 7) {
                System.out.print("Enter a List Size : ");
                while (true) {
                    try {
                        size = Integer.parseInt(userInput.nextLine());
                        if (size > 0) break;
                        System.out.print("Size must be > 0: ");
                    } catch (NumberFormatException e) {
                        System.out.print(error.errorInput);
                    }
                }
            }

            int[] elements = new int[size];
            if (choice < 7) {
                for (int i = 0; i < size; i++) {
                    while (true) {
                        System.out.print("Enter value at position " + (i + 1) + " : ");
                        try {
                            elements[i] = Integer.parseInt(userInput.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(error.errorInput);
                        }
                    }
                }
            }

            switch (choice) {
                case 1 -> {

                    int initialEnergy = 0;
                    while (true) {
                        System.out.print("Enter your initialEnergy : ");
                        try {
                            initialEnergy = Integer.parseInt(userInput.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(error.errorInput + " like :- (1,2,3,4)");
                        }
                    }
                    System.out.println("City travel by using energy :- " + task.efficientTravel(elements, initialEnergy));
                }
                case 2 -> {
                    System.out.println("Prefix and Suffix at index :- " + task.sumPrefixSuffix(elements));
                }

                case 3 -> {
                    boolean valid = true;
                    for (int value : elements) {
                        if (value != 0 && value != 1) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        System.out.println("Minimum number of flips : " + task.minFlips(elements));
                    } else {
                        System.out.println(error.errorInput + "! Only 0 and 1 are allowed.");
                    }
                }
                case 4 -> {
                    System.out.println("Single element : " + task.oneOut(elements));
                }
                case 5 -> {
                    int target = 0;
                    while (true) {
                        try {
                            target = Integer.parseInt(userInput.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(error.errorInput + "enter  like :- (1,2,3,4)");
                        }
                    }
                    System.out.println("Pair is exist or not :- " + task.isPair(elements, target));
                }
                case 6 -> {
                    System.out.println("Total time taken after skipping one wall :- " + task.miniPainter(elements));
                }

                case 7 -> {
                    MyArray.GeometryOperations go = task.new GeometryOperations();
                    go.performOperations();
                }
                default -> System.out.println("What are you doing man ?. Please select from 1 to 8.");

            }
            System.out.println("------------------------------------------------------\n");
        }
    }
}