Autor: Tobiasz Kaciuczyk

Aplikacja korzysta z bazy danych MySQL, domyślnie adres: localhost:3306, nazwa: car-rental, użytkownik: root, bez hasła.

Do testowania API wykorzystałem narzędzie Postman.

Wstawienie przykładowych danych do bazy:
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

W celu wyświetlenia wszystkich wprowadzonych danych najlepiej wywołać metodę get na wypożyczeniach:
1. GET: localhost:8080/rents