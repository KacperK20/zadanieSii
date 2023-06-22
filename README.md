# zadanieSii
Rezerwacja wykładu
URL: /conference/bookLecture/{lectureId}
Metoda: POST
Przykładowe żądanie:
URL: /conference/bookLecture/1
{
    "userName": "jan",
    "email": "jan@oo.com"
}

Wyswietlenie wszystkich uzytkowników
URL: /conference/users
Metoda: GET
URL: /conference/users

Anulowanie rezerwacji
URL: /conference/cancelReservation/{lectureId}/{userName}
Metoda: DELETE
URL: /conference/cancelReservation/1/jan



Aktualizacja adresu e-mail użytkownika
URL: /conference/{userName}/email
Metoda: PUT
URL: /conference/jan/email
{
    "email": "nowyEmail@oo.com"
}


Pobranie listy wszystkich rezerwacji dla użytkownika
URL: /conference/reservations/{userName}
Metoda: GET
URL: /conference/reservations/jan


Pobranie listy wszystkich wykładów
URL: /conference/plan
Metoda: GET
URL: /conference/plan


Do implementacji:
Generowanie raportu zainteresowania wykładami
URL: /conference/report/lectureInterest
Metoda: GET



Generowanie raportu zainteresowania ścieżkami tematycznymi
URL: /conference/report/trackInterest
Metoda: GET

