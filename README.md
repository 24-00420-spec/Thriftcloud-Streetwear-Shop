# Thriftcloud-Streetwear-Shop
 BSIT 2110
 
 Barrio,Mark Joseph R.
 
 De Roma,Josh Andrei A.
 
 Navarro,Ritch B.


# Overview
This program is a console-based shopping system named ThriftCloud Shop. It allows users to browse items, search products, add items to a cart, remove items, and proceed to checkout. The system uses object-oriented programming concepts and Java's BigDecimal class for accurate price handling.

The application maintains an internal list of products and provides an interactive menu-driven interface that ensures user-friendly navigation and validated inputs.

Users can:

View all available products

Search products by name or category

Add selected items to the cart

View and remove items from the cart

Proceed to checkout and clear their cart

Exit the shop safely

# Project Structure

    📁 ThriftCloudShop/
        │── Main.java      

 



# How to Run the Program
1.Ensure Java JDK 8+ is installed.

2.Save your code as Main.java.

3.Open your terminal/command prompt.

4.Navigate to the folder containing Main.java.

5.Compile the program:


#  Object-Oriented Principles: 
 Encapsulation –
Implemented through the Item class, which groups related data such as title, description, price, and category. These values are packaged inside the class and accessed only through object instances, ensuring organized and secure data handling.

Abstraction –
The program hides complex operations (displaying items, searching, checking out, handling input) behind simple method calls like displayItems(), searchItem(), viewCart(), and checkout(). This allows users to interact with the system without seeing the internal logic.

Inheritance –
While the current program does not use class inheritance (no subclasses extend Item), it still follows object-oriented design through the use of well-structured classes. If expanded, categories such as Shirts, Jackets, or Shoes could inherit from a base Item class to reuse and extend functionality.

Polymorphism –
Although no method overriding is used, the program demonstrates basic polymorphism through object handling: Item objects are stored in lists (items and cart) and processed uniformly. Methods like printCard() accept an Item object and work correctly regardless of what product is passed in.


# Sample output

    ===============================/
          THRIFTCLOUD SHOP
    ===============================
    1. View All Items
    2. Search Item
    3. View Cart
    4. Checkout
    5. Exit
    Choose an option: 1

    ========= PRODUCT LIST =========

    Item #1
    ----------------------------------------
    PRODUCT: Nirvana 'Nevermind' Tee
    CATEGORY: Shirts
    PRICE: 1800
    DESCRIPTION: Vintage faded black band tee.
    ----------------------------------------

    Item #2
    ----------------------------------------
    PRODUCT: BAPE Camo Logo Tee
    CATEGORY: Shirts
    PRICE: 2500
    DESCRIPTION: Classic A Bathing Ape shirt.
    ----------------------------------------

    Item #3
    ----------------------------------------
    PRODUCT: Coogi Style Sweater
    CATEGORY: Shirts
    PRICE: 3200
    DESCRIPTION: Colorful textured knit sweater.
    ----------------------------------------

    Item #4
    ----------------------------------------
    PRODUCT: Carhartt Workwear Jacket
    CATEGORY: Jackets
    PRICE: 3500
    DESCRIPTION: Vintage utility jacket.
    ----------------------------------------

    Item #5
    ----------------------------------------
    PRODUCT: Polo Japan Track Jacket
    CATEGORY: Jackets
    PRICE: 2800
    DESCRIPTION: Full-zip jacket with patch.
    ----------------------------------------

    Item #6
    ----------------------------------------
    PRODUCT: Wide-Leg Denim Jeans
    CATEGORY: Pants
    PRICE: 1100
    DESCRIPTION: Dark wash wide-leg jeans.
    ----------------------------------------

    Item #7
    ----------------------------------------
    PRODUCT: Brown Wide Trousers
    CATEGORY: Pants
    PRICE: 1000
    DESCRIPTION: High-waisted trousers.
    ----------------------------------------

    Item #8
    ----------------------------------------
    PRODUCT: Adidas Track Skirt
    CATEGORY: Pants
    PRICE: 900
    DESCRIPTION: Black skirt with 3 stripes.
    ----------------------------------------

    Item #9
    ----------------------------------------
    PRODUCT: PUMA Suede Sneakers
    CATEGORY: Shoes
    PRICE: 2000
    DESCRIPTION: Classic suede shoes.
    ----------------------------------------

    Item #10
    ----------------------------------------
    PRODUCT: VANS Old Skool Black
    CATEGORY: Shoes
    PRICE: 1400
    DESCRIPTION: Iconic low-top sneakers.
    ----------------------------------------

    Item #11
    ----------------------------------------
    PRODUCT: Onitsuka Tiger White
    CATEGORY: Shoes
    PRICE: 1250
    DESCRIPTION: White sneakers with stripes.
    ----------------------------------------

    Item #12
    ----------------------------------------
    PRODUCT: Chrome Cross Necklace
    CATEGORY: Accessories
    PRICE: 1500
    DESCRIPTION: Silver-tone pendant.
    ----------------------------------------

    Item #13
    ----------------------------------------
    PRODUCT: NY Yankees Cap
    CATEGORY: Accessories
    PRICE: 850
    DESCRIPTION: Cream/brown cap.
    ----------------------------------------

    Item #14
    ----------------------------------------
    PRODUCT: Spider-Man Headphones
    CATEGORY: Accessories
    PRICE: 1800
    DESCRIPTION: Black over-ear headphones.
    ----------------------------------------
    Enter item number to ADD TO CART (0 to go back): 3
    Coogi Style Sweater added to cart!

# Search Item

     ===============================
       THRIFTCLOUD SHOP
    ===============================
    1. View All Items
    2. Search Item
    3. View Cart
    4. Checkout
    5. Exit
    Choose an option: 2
    Enter search keyword: carhartt

    ========= PRODUCT LIST =========

    Item #1
    ----------------------------------------
    PRODUCT: Carhartt Workwear Jacket
    CATEGORY: Jackets
    PRICE: 3500
    DESCRIPTION: Vintage utility jacket.
    ----------------------------------------
    Enter item number to ADD TO CART (0 to go back): 1
    Carhartt Workwear Jacket added to cart!

# View Cart


    ===============================
       THRIFTCLOUD SHOP
    ===============================
    1. View All Items
    2. Search Item
    3. View Cart
    4. Checkout
    5. Exit
    Choose an option: 3
    
    =========== YOUR CART ===========
    
    Cart Item #1
    ----------------------------------------
    PRODUCT: Chrome Cross Necklace
    CATEGORY: Accessories
    PRICE: 1500
    DESCRIPTION: Silver-tone pendant.
    ----------------------------------------
    
    Cart Item #2
    ----------------------------------------
    PRODUCT: Spider-Man Headphones
    CATEGORY: Accessories
    PRICE: 1800
    DESCRIPTION: Black over-ear headphones.
    ----------------------------------------
    TOTAL: 3300
    
    
#Checkout

    ===============================
           THRIFTCLOUD SHOP
    ===============================
    1. View All Items
    2. Search Item
    3. View Cart
    4. Checkout
    5. Exit
    Choose an option: 4
    
    ========== CHECKOUT ==========
    - Chrome Cross Necklace : 1500
    - Spider-Man Headphones : 1800
    --------------------------------
    TOTAL AMOUNT: 3300
    --------------------------------
    Confirm checkout? (yes/no): yes
    Payment successful! Thank you for your purchase.



#Exit

    ===============================
       THRIFTCLOUD SHOP
    ===============================
    1. View All Items
    2. Search Item
    3. View Cart
    4. Checkout
    5. Exit
    Choose an option: 5
    Thank you for visiting!




# Acknowledgments
To our CS 211 instructor, we offer our deepest gratitude for supporting us through every challenge this semester. Your patience, understanding, and dedication have guided us more than you know.
