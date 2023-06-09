package org.example;

public class Bank {

    public Client[] clients;

    public Bank(Client[] clients) {
        this.clients = clients;
    }

    public void addClient(Client client) {
        int lengthOfArray = clients.length + 1;
        Client[] addClients = new Client[lengthOfArray];

        for (int i = 0; i < clients.length; i++) {
            addClients[i] = clients[i];
        }
        addClients[lengthOfArray - 1] = client;
        clients = addClients;
    }

    public void printClients() {
        for (Client clientt : clients) {
            System.out.print(" Nazwisko klienta: " + clientt.getName());
            System.out.print(" Saldo: " + clientt.getBalance());
            System.out.print(" Nr konta: " + clientt.getAccountNumber());
            System.out.println();
        }
    }

    public void removeClient(String accountNumber) {
        if (getClientByAccountNumber(accountNumber) != null) {
            Client[] removedClient = new Client[clients.length - 1];
            int counter = 0;
            for (int i = 0; i < clients.length; i++) {
                if (!clients[i].getAccountNumber().equals(accountNumber)) {
                    removedClient[counter] = clients[i];
                    counter++;
                }
            }
            clients = removedClient;
        }
    }

    public int getClientCount() {
        return clients.length;
    }

    public Client getClientByAccountNumber(String accountNumber) {

        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getAccountNumber().equals(accountNumber)) {
                return clients[i];
            }
        }
        return null;
    }

    public boolean deposit(String accountNumber, double amount) {
        Client client = getClientByAccountNumber(accountNumber);
        if (client != null) {
            client.setBalance(client.getBalance() + amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(String accountNumber, double amount) {
        Client client = getClientByAccountNumber(accountNumber);
        if (client != null) {
            client.setBalance(client.getBalance() - amount);
            return true;
        }
        return false;
    }

    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        if ((getClientByAccountNumber(fromAccountNumber) != null) && (getClientByAccountNumber(toAccountNumber)) != null) {
            deposit(toAccountNumber,amount);
            withdraw(fromAccountNumber,amount);
            return true;
        }
        return false;
    }
}
