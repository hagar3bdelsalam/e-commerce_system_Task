# E-commerce System

A comprehensive Java-based e-commerce system that handles products, shopping carts, customers, and checkout processes with support for different product types, expiration management, and shipping.

## Features

### Product Management

- **Multiple Product Types**: Expirable, Non-expirable, and other products
- **Expiration Handling**: Some products expire (cheese, biscuits) while others don't (TV, mobile)
- **Shipping Requirements**: Some products require shipping, others don't (digital scratch cards)
- **Inventory Tracking**: Real-time stock quantity management

### Shopping Cart

- Add products with quantity validation
- Prevents adding more items than available stock
- Handles duplicate products by updating quantities
- Comprehensive error handling

### Checkout System

- **Order Validation**: Checks for empty cart, and customer balance
- **Automatic Calculations**: Subtotal, shipping fees, and total amount
- **Payment Processing**: Deducts amount from customer balance

### Shipping Service

- **Weight-based Calculation**: $5 per kg
- **Shipment Notices**: Displays items to be shipped with weights
- **Smart Filtering**: Only processes items that require shipping

## Design Patterns & Principles

### Interfaces Used

- `Expirable`: For products that can expire
- `Shippable`: For products that need shipping with weight information

## Class Structure

```
Product (Abstract)
├── ExpirableProducts (implements Expirable, Shippable)
├── NonExpirableProducts (implements Shippable)
└── OtherProducts

Other Classes:
├── Customer
├── Cart
├── CartItems
├── ShippingService
└── Main
```

## Error Handling

The system handles various error scenarios:

### Cart Validation

- **Empty Cart**: `"ERROR: Cart is empty. Cannot complete purchase."`
- **Expired Products**: `"ERROR: Product 'Cheese' is expired and cannot be added to the cart"`
- **Out of Stock**: `"ERROR: Not enough stock available for 'TV'"`
- **Insufficient Balance**: `"ERROR: Insufficient balance to complete the purchase."`

### Input Validation

- **Invalid Quantity**: Prevents adding zero or negative quantities
- **Stock Limits**: Prevents adding more items than available in inventory
- **Duplicate Items**: Automatically handles adding same product multiple times

## Test Cases Included

1. **Successful Checkout**: Mixed product types with shipping
2. **Empty Cart**: Error handling for empty cart
3. **Expired Products**: Error handling for expired items
4. **Insufficient Balance**: Error handling for insufficient funds
5. **Out of Stock**: Error handling for stock limitations

## Key Assumptions

- **Shipping Calculation**: $5 per kg
- **Weight Units**: All weights in kilograms
- **Currency**: All prices in USD
- **Expiration Check**: Based on current system date
- **Stock Updates**: Automatic inventory reduction after successful addition
- **Cart Behavior**: Cleared after successful checkout

## How to Run

1. Compile the Java file:

   ```bash
   javac Main.java
   ```

2. Run the main:

   ```bash
   java Main
   ```

3. The main will run all test cases and display results in the console.
