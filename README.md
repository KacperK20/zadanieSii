# zadanieSii
Uzupelnienie bazy danych H2
INSERT INTO lectures (id, start, title, track)
VALUES 
    (1, '2023-06-22 10:00:00', 'Introduction to SQL', 5),
    (2, '2023-06-22 12:00:00', 'Introduction to SQL', 5),
    (3, '2023-06-22 14:00:00', 'Introduction to SQL', 5),
    (4, '2023-06-22 10:00:00', 'Introduction to JAVA', 5),
    (5, '2023-06-22 12:00:00', 'Introduction to JAVA', 5),
    (6, '2023-06-22 14:00:00', 'Introduction to JAVA', 5),
    (7, '2023-06-22 10:00:00', 'Introduction to PHP', 5),
    (8, '2023-06-22 12:00:00', 'Introduction to PHP', 5),
    (9, '2023-06-22 14:00:00', 'Introduction to PHP', 5);

INSERT INTO users (id, email, username)
VALUES
  (1, 'jan@oo.com', 'jan'),
  (2, 'Kacper@oo.com', 'Kacper'),
  (3, 'Maciej@oo.com', 'Maciej'),
  (4, 'Jola@oo.com', 'Jola'),
  (5, 'Ola@oo.com', 'Ola'),
  (6, 'Adrian@oo.com', 'Adrian');



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

