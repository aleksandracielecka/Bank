package org.example;
//Napisz program, który będzie symulować działanie banku. Zaimplementuj klasy:
//a. Klasę Client, reprezentującą klienta banku. Klasa powinna zawierać pola: name (typu String), accountNumber (typu String) oraz balance (typu double chyba że dasz radę inaczej), reprezentujące odpowiednio imię i nazwisko klienta, numer konta oraz saldo.
//b. Klasę Bank, reprezentującą bank. Klasa powinna zawierać pole clients, będące tablicą obiektów typu Client, oraz metody:
//
//addClient(Client client): dodająca nowego klienta do tablicy clients,
//removeClient(String accountNumber): usuwająca klienta o podanym numerze konta z tablicy clients,
//getClientCount(): zwracająca liczbę klientów w banku,
//getClientByAccountNumber(String accountNumber): zwracająca obiekt klienta o podanym numerze konta,
//deposit(String accountNumber, double amount): dokonująca wpłaty na konto klienta o podanym numerze konta,
//withdraw(String accountNumber, double amount): dokonująca wypłaty z konta klienta o podanym numerze konta,
//transfer(String fromAccountNumber, String toAccountNumber, double amount): dokonująca przelewu z jednego konta na drugie.
//c. Klasę Main, w której znajdzie się metoda main, a w niej kod, w którym:
//i. Stworzysz obiekt banku.
//ii. Dodasz kilku klientów do banku, korzystając z metody addClient.
//iii. Wywołasz odpowiednie metody, aby dokonać wpłat, wypłat i przelewów między kontami klientów.
//iv. Wypiszesz na ekranie informacje o wszystkich klientach w banku.
//Twoim zadaniem jest implementacja klas Client, Bank oraz metody main zgodnie z podanymi wymaganiami.

public class App 
{
    public static void main( String[] args )
    {
        Client[] clients = new Client[0];
        Bank bank = new Bank(clients);


        Client nowak = new Client("Nowak", "8985", 10);
        Client zieba = new Client("Zięba", "4205", 700);
        Client lis = new Client("Lis", "1010", -500);
        Client cielecka = new Client("Cielecka", "0000", 5000);
        bank.addClient( new Client("Kowalski", "2223", 1000));
        bank.addClient(nowak);
        bank.addClient( zieba);
        bank.addClient( lis);

        bank.addClient(cielecka);

        Client clientByAccountNr =  bank.getClientByAccountNumber("0000");
        System.out.println(clientByAccountNr);

        bank.removeClient("8985");
        bank.addClient(nowak);

        int clientCount = bank.getClientCount();
        System.out.println(clientCount);

        bank.deposit("0000",5000);
        System.out.println(cielecka.getBalance());

        bank.transfer("0000","1010",500);
        System.out.println(cielecka.getBalance());
        System.out.println(lis.getBalance());

        bank.printClients();

    }
}
