import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println(Product.unit);
        System.out.println("Nhập số lượng sản phẩm");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Thông tin sản phẩm: ");
        Product[] productlist = new Product[n];
        for (int i = 0; i < productlist.length; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1));
            productlist[i] = products(sc);
        }

        for (int i = 0; i < productlist.length; i++) {
            System.out.println(productlist[i].toString());
        }
//        Tìm sản phẩm theo tên
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String nameProduct = sc.nextLine();
        int count = 0;
        for (int i = 0; i < productlist.length; i++) {
            if (productlist[i].getName().equals(nameProduct)) {
                System.out.println(productlist[i]);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Sản phẩm không có trong dang mục");
        }

//        Tính tổng giá các sản phẩm
        int sumProduct = 0;
        for (int i = 0; i < productlist.length; i++) {
            sumProduct+=productlist[i].getPrice();
        }
        System.out.println("Tổng giá sản phẩm = "+ sumProduct);

    }


    public static Product products(Scanner sc) {
        String code;
        String name;
        double price;
        String type;
        System.out.println("Nhập code: ");
        code = sc.nextLine();
        System.out.println("Nhập tên: ");
        name = sc.nextLine();
        System.out.println("Nhập giá: ");
        price = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập loại: ");
        type = sc.nextLine();

        return new Product(code, name, price, type);
    }


}
