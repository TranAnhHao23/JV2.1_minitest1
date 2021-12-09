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
            sumProduct += productlist[i].getPrice();
        }
        System.out.println("Tổng giá sản phẩm = " + sumProduct);

//        Nâng cao 1: Xây dựng hàm sửa sản phẩm theo mã
        System.out.println("Điền mã để sửa sản phẩm");
        String code = sc.nextLine();
        insertItem(code,productlist,sc);
        for (int i = 0; i < productlist.length; i++) {
            System.out.println(productlist[i].toString());
        }

//        Nâng cao 2: Xây dựng hàm xóa sản phẩm theo mã

        System.out.println("Điền mã để xóa sản phẩm");
        String code2 = sc.nextLine();
        Product[] productsNew = deleteItem(code2,productlist,sc);
//        deleteItem(code2,productlist,sc);
        for (int i = 0; i < productsNew.length; i++) {
            System.out.println(productlist[i].toString());
        }
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

    public static Product[] insertItem(String code, Product[] productslist, Scanner sc) {
        int count = 0;
        for (int i = 0; i < productslist.length; i++) {
            if (productslist[i].getCode().equals(code)) {
                count++;
                System.out.println("Sửa lại sản phẩm thứ " + (i + 1));
                System.out.println("Nhập tên");
                productslist[i].setName(sc.nextLine());
                System.out.println("Nhập giá");
                productslist[i].setPrice(sc.nextInt());
                sc.nextLine();
                System.out.println("Nhập loại");
                productslist[i].setType(sc.nextLine());
            }
        }
        if (count == 0) {
            System.out.println("Không tồn tại sản phẩm trong data");
        }
        return productslist;
    }

    public static Product[] deleteItem(String code, Product[] productslist, Scanner sc) {
        int count = 0;

        for (int i = 0; i < productslist.length; i++) {
            int c=0;
            if (!productslist[i].getCode().equals(code)) {
                productslist[c] = productslist[i];
                c++;
                count++;
            }
        }
        Product[] productlistNew = new Product[productslist.length - count];
        for (int i = 0; i < productlistNew.length; i++) {
            productlistNew[i] = productslist[i];
        }
        return productlistNew;
    }
}
