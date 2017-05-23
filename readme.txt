Application use MySQL database with default adres: localhost:3306, name: car-rental, user: root, without password.

Example Api tests (Postman):

I. Car
1. POST: localhost:8080/cars
    {
        "brand": "Ferrari",
        "model": "California",
        "seats": 5
    }
2. POST: localhost:8080/cars
    {
        "brand": "Mercedes",
        "model": "McLaren",
        "seats": 4
    }
II. Customer
1. POST: localhost:8080/customers
    {
        "firstName": "Jan",
        "lastName": "Kowalski",
        "phoneNumber": "555555777"
    }
2. POST: localhost:8080/customers
    {
        "firstName": "Tadeusz",
        "lastName": "Nowak",
        "phoneNumber": "111111111"
    }
III. Rent
1. POST: localhost:8080/rents
    {
        "car": {
          "id": 1
        },
        "customer": {
          "id": 1
        },
        "startDate": "2012-12-12"
    }
2. POST: localhost:8080/rents
    {
        "car": {
            "id": 2
        },
        "customer": {
              "id": 2
        },
        "startDate": "2012-12-12",
        "endDate": "2012-12-13"
    }

The best way to display results:
1. GET: localhost:8080/rents
