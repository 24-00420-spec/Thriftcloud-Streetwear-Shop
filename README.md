# Thriftcloud-Streetwear-Shop
Swing–based thrift shopping marketplace

# Overview
Thriftcloud Shop is a desktop thrift shopping marketplace built using Java Swing.
It features a vintage + streetwear catalog, a live featured item image carousel, category
filtering, a cart system, and an interactive UI for browsing second-hand fashion items.

Users can:
● Search for thrift items by name

●  Filter items using category buttons (Shirts, Jackets, Pants, Shoes, Accessories)

● Add single or multiple items to the cart

●  View item details on click (image + description + price)

●  Checkout and complete a thrift purchase

# Project Structure

    📂 ThriftcloudShop/
     │── ☕ ThriftcloudCoolShop.java/
     │
     └── 📂 images/
        ├── 👕 red_polo.png
        ├── 👚 white_shirt.png
        ├── 👕 blue_tshirt.png
        ├── 🧥 green_hoodie.png
        ├── 👖 blue_jeans.png
        ├── 👖 black_chinos.png
        ├── 👖 grey_sweatpants.png
        ├── 👖 khaki_pants.png
        ├── 👟 running_sneakers.png
        ├── 👟 casual_sneakers.png
        ├── 🥿 black_loafers.png
        └── 🥾 brown_boots.png



# How to Run the Program
1. Open the ThriftcloudShop folder in any Java IDE (VS Code / IntelliJ / NetBeans /
Eclipse, etc.)

 2.Compile and run:
   ThriftcloudCoolShop.java
  
3. Browse thrift fashion and enjoy the shop UI!


#  Object-Oriented Principles: 
Encapsulation –
Applied through the Item class fields (title, description, price, category, imagePath, and available). These variables are kept inside the class and initialized through the constructor, preventing unauthorized modification from outside. The available field is also controlled internally when checkout happens, ensuring safer data handling.

 Abstraction –
The Item class acts as a blueprint that hides implementation details of the shop items. The UI does not need to know how each item stores its data—only that it can retrieve and display it. Methods like the constructor and object usage through .title, .price, and .category abstract the underlying structure.

 Inheritance –
ThriftcloudCoolShop extends JFrame, inheriting all window properties and behaviors such as layout handling, visibility, sizing, and closing operations. This allows the shop to function as a window without rewriting core GUI frame logic.

 Polymorphism –
Different JPanel item cards are created dynamically using new Item(...) objects from the same List<Item>. When shop methods access it.title, it.description, or pass the object to showItemDetail(it), the behavior is determined at runtime depending on the actual item selected or stored, demonstrating runtime polymorphism through shared object handling.

