
class PlaceOrder {
    public void viewCatalog () {
        /*logic goes here*/
    }
    public void addProduct () {
        /*logic goes here*/
    }

    public void makePayment () {
        /*logic goes here*/
    }
}

/*
    Instead of incorporating all the methods in a single calss make multiple classes with atomic jobs.
*/
class CatalogService {
    public void viewCatalog () {
        /*logic goes here*/
    }
}

class ProductService {
    public void addProduct () {
        /*logic goes here*/
    }
}

class PaymentService {
    public void makePayment () {
        /*logic goes here*/
    }
}

