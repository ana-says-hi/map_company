
Application for managing a bio care products company
The functions are divided according to the user's roles: manager, customer, or courier.
The customer can browse products, add them to the cart, place orders, view order history, and update personal information.
The manager can add/delete products, modify product details, view sales reports, manage inventory, and handle customer inquiries.
The courier can view assigned deliveries, update delivery status, and provide delivery feedback.
Additionally, the application allows users to choose between volatile storage (data deleted at the end of the program execution) or persistent storage (data saved in a PostgreSQL database).


Everything about it should be in the Lab2.pdf file (it is in german)

Design patterns used:
  Decorator : für Delivery
  Factory : zur automatischen Erstellung von IDs 
  Singelton : prüft, ob es in der Factory nur eine Instanz mit einer ID gibt
  Memento : es behält den Status einer Bestellung bei und gibt Benachrichtigungen über den Observer aus
  Command Process : befasst sich mit der Validierung und Ausführung von Aufträgen
  Observer : Benachrichtigung, wenn der Bestand unter 50 fällt
