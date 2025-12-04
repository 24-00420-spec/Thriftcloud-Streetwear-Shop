import java.util.*;
import java.math.BigDecimal;

public class Main {

    static class Item {
        String title, description;
        BigDecimal price;
        String category;

        public Item(String title, String desc, BigDecimal price, String category) {
            this.title = title;
            this.description = desc;
            this.price = price;
            this.category = category;
        }
    }

    private static final List<Item> items = new ArrayList<>();
    private static final List<Item> cart = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        seedItems();
        showMenu();
    }

    private static void showMenu() {
        while (true) {
            System.out.println("\n===============================");
            System.out.println("       THRIFTCLOUD SHOP");
            System.out.println("===============================");
            System.out.println("1. View All Items");
            System.out.println("2. Search Item");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = getValidIntInput();

            switch (choice) {
                case 1 -> displayItems(items);
                case 2 -> searchItem();
                case 3 -> viewCart();
                case 4 -> checkout();
                case 5 -> {
                    System.out.println("Thank you for visiting!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static int getValidIntInput() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input, enter a number: ");
            }
        }
    }

    private static void displayItems(List<Item> list) {
        if (list.isEmpty()) {
            System.out.println("\nNo items found.");
            return;
        }

        System.out.println("\n========= PRODUCT LIST =========");
        int index = 1;
        for (Item item : list) {
            System.out.println("\nItem #" + index);
            printCard(item);
            index++;
        }

        System.out.print("Enter item number to ADD TO CART (0 to go back): ");
        int choice = getValidIntInput();

        if (choice == 0) return;

        if (choice < 1 || choice > list.size()) {
            System.out.println("Invalid item number.");
            return;
        }

        cart.add(list.get(choice - 1));
        System.out.println(list.get(choice - 1).title + " added to cart!");
    }

    private static void printCard(Item item) {
        System.out.println("----------------------------------------");
        System.out.println("PRODUCT: " + item.title);
        System.out.println("CATEGORY: " + item.category);
        System.out.println("PRICE: ₱" + item.price.toPlainString());
        System.out.println("DESCRIPTION: " + item.description);
        System.out.println("----------------------------------------");
    }

    private static void searchItem() {
        System.out.print("Enter search keyword: ");
        String keyword = sc.nextLine().trim().toLowerCase();

        List<Item> result = new ArrayList<>();

        for (Item i : items) {
            if (i.title.toLowerCase().contains(keyword) ||
                i.category.toLowerCase().contains(keyword)) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            System.out.println("\nNo matching items found.");
        } else {
            displayItems(result);
        }
    }

    private static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty.");
            return;
        }

        System.out.println("\n=========== YOUR CART ===========");
        int index = 1;
        BigDecimal total = BigDecimal.ZERO;

        for (Item item : cart) {
            System.out.println("\nCart Item #" + index);
            printCard(item);
            total = total.add(item.price);
            index++;
        }

        System.out.println("TOTAL: ₱" + total.toPlainString());

        System.out.print("\nEnter item number to REMOVE (0 to go back): ");
        int choice = getValidIntInput();

        if (choice == 0) return;

        if (choice < 1 || choice > cart.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Item removed = cart.remove(choice - 1);
        System.out.println(removed.title + " removed from cart!");
    }

    private static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty. Add items first!");
            return;
        }

        System.out.println("\n========== CHECKOUT ==========");
        BigDecimal total = BigDecimal.ZERO;

        for (Item item : cart) {
            System.out.println("- " + item.title + " : ₱" + item.price);
            total = total.add(item.price);
        }

        System.out.println("--------------------------------");
        System.out.println("TOTAL AMOUNT: ₱" + total.toPlainString());
        System.out.println("--------------------------------");

        System.out.print("Confirm checkout? (yes/no): ");
        String confirm = sc.nextLine().trim().toLowerCase();

        if (confirm.equals("yes")) {
            cart.clear();
            System.out.println("Payment successful! Thank you for your purchase.");
        } else {
            System.out.println("Checkout cancelled.");
        }
    }

    private static void seedItems() {
        items.add(new Item("Nirvana 'Nevermind' Tee", "Vintage faded black band tee.", new BigDecimal("1800"), "Shirts"));
        items.add(new Item("BAPE Camo Logo Tee", "Classic A Bathing Ape shirt.", new BigDecimal("2500"), "Shirts"));
        items.add(new Item("Coogi Style Sweater", "Colorful textured knit sweater.", new BigDecimal("3200"), "Shirts"));

        items.add(new Item("Carhartt Workwear Jacket", "Vintage utility jacket.", new BigDecimal("3500"), "Jackets"));
        items.add(new Item("Polo Japan Track Jacket", "Full-zip jacket with patch.", new BigDecimal("2800"), "Jackets"));

        items.add(new Item("Wide-Leg Denim Jeans", "Dark wash wide-leg jeans.", new BigDecimal("1100"), "Pants"));
        items.add(new Item("Brown Wide Trousers", "High-waisted trousers.", new BigDecimal("1000"), "Pants"));
        items.add(new Item("Adidas Track Skirt", "Black skirt with 3 stripes.", new BigDecimal("900"), "Pants"));

        items.add(new Item("PUMA Suede Sneakers", "Classic suede shoes.", new BigDecimal("2000"), "Shoes"));
        items.add(new Item("VANS Old Skool Black", "Iconic low-top sneakers.", new BigDecimal("1400"), "Shoes"));
        items.add(new Item("Onitsuka Tiger White", "White sneakers with stripes.", new BigDecimal("1250"), "Shoes"));

        items.add(new Item("Chrome Cross Necklace", "Silver-tone pendant.", new BigDecimal("1500"), "Accessories"));
        items.add(new Item("NY Yankees Cap", "Cream/brown cap.", new BigDecimal("850"), "Accessories"));
        items.add(new Item("Spider-Man Headphones", "Black over-ear headphones.", new BigDecimal("1800"), "Accessories"));
    }
}
