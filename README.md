# Shopping Cart System (Java)

A console-based, multi-store shopping cart application written in Java, applying object-oriented design with a clear DTO / Service layer separation.

## Features
- Multi-store support (`Shop1Service`, `Shop2Service`, `Shop3Service`) — each store manages its own customers, products and rankings independently
- Authentication (`AuthenService`) per store
- Shopping cart logic — add/remove items, calculate totals (`CartItemService`, `ShoppingCartService`)
- Customer and product management (`CustomerService`, `ProductService`)
- Ranking system for customers (`RankService`)
- Simple data persistence using `.txt` files as a lightweight database per store (`customer.txt`, `product.txt`, `rank.txt`)
- Logging (`LogService`) and email notifications (`EmailService`)

## Project Structure
```
src/com/longg/
├── dto/        # Data models: Cart, CartItem, Customer, Product, Rank, Shop, Log
├── service/    # Business logic, split per store (Shop1/2/3Service)
├── common/     # Shared storage/file I/O logic
└── Main.java   # Entry point
```

## Tech
Java — OOP design (DTO/Service layers), file-based data storage

## What I Practised
- Structuring a Java application into DTO and Service layers rather than one large class
- Designing multiple, independently-managed "stores" using shared service interfaces/patterns
- Reading and writing structured data from `.txt` files
