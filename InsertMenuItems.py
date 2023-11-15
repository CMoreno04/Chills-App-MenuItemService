from pymongo import MongoClient
import pymongo

# Combined list of products
products = [
    {"name": "Mozzarella Sticks", "price": 5.99, "description": "A classic appetizer made with breaded mozzarella cheese served with marinara sauce.", "imageUrl": "images/mozzarella_sticks.jpg","category" : "Appetizers"},
    {"name": "Hamburger", "price": 8.99, "description": "A classic hamburger made with our house blend of beef, served with lettuce, tomato, and onion and melted cheese.", "imageUrl": "images/hamburger.jpg","category" : "Entrees"},
    {"name": "Pepperoni Pizza", "price": 14.99, "description": "A classic pizza topped with tomato sauce, mozzarella cheese, and pepperoni.", "imageUrl": "images/pepperoni-pizza.jpg", "category" : "Entrees"},
    {"name": "French Fries", "price": 3.99, "description": "A side of crispy french fries.", "imageUrl": "images/french-fries.jpg", "category" : "Sides"},
    {"name": "Tiramisu", "price": 5.99, "description": "A classic Italian dessert made with ladyfingers, mascarpone, and espresso.", "imageUrl": "images/tiramisu.jpg", "category" : "Desserts"},
    {"name": "Coca-Cola", "price": 2.99, "description": "A can of Coca-Cola.", "imageUrl": "images/coca-cola.jpg", "category" : "Beverages"}
]

# Load image blobs directly into products
for product in products:
    with open(product["imageUrl"], 'rb') as imageFile:
        product["imageBlob"] = imageFile.read()

# Establish a connection to MongoDB
client = MongoClient('mongodb://localhost:27017/')  # adjust the connection URL as needed
db = client['chillsdb']  # name of your database
collection = db['menu_item']  # name of your collection

# Insert the products into MongoDB
result = collection.insert_many(products)

# Print the IDs of the inserted documents
print(f"Inserted IDs: {result.inserted_ids}")
