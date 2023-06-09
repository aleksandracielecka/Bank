package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    @Test
    void shouldReturnClientForGivenNumber(){

        Client[] clients = new Client[0];
        Bank bank = new Bank(clients);
        Client nowak = new Client("Nowak", "8985", 10);
        bank.addClient(nowak);

        Client clientByAccountNumber = bank.getClientByAccountNumber("8985");

        assertEquals("8985",clientByAccountNumber.getAccountNumber());
        assertEquals("Nowak",clientByAccountNumber.getName());
        assertEquals(10,clientByAccountNumber.getBalance());

    }
    @Test
    void shouldReturnNullForGivenNumberWhenClientIsNotAvailable() {

        Client[] clients = new Client[0];
        Bank bank = new Bank(clients);
        Client nowak = new Client("Nowak", "8985", 10);
        bank.addClient(nowak);

        Client clientByAccountNumber = bank.getClientByAccountNumber("1111");

        assertEquals(null, clientByAccountNumber);
    }
    @Test
    void shouldReturnNumberOfClients() {

        Client[] clients = new Client[0];
        Bank bank = new Bank(clients);
        Client nowak = new Client("Nowak", "8985", 10);
        Client zieba = new Client("Zięba", "4205", 700);
        bank.addClient(nowak);
        bank.addClient(zieba);

        int clientCount = bank.getClientCount();

        assertEquals(2, clientCount);

    }
    @Test
    void shouldRemoveClientWithGivenNumber() {

        Client[] clients = new Client[0];
        Bank bank = new Bank(clients);
        Client nowak = new Client("Nowak", "8985", 10);
        Client zieba = new Client("Zięba", "4205", 700);
        bank.addClient(nowak);
        bank.addClient(zieba);

        bank.removeClient("8985");

        assertEquals(1, bank.getClientCount());

    }
    @Test
    void shouldNotRemoveClientWhenGivenNumberDoesntExists() {

        Client[] clients = new Client[0];
        Bank bank = new Bank(clients);
        Client nowak = new Client("Nowak", "8985", 10);
        Client zieba = new Client("Zięba", "4205", 700);
        bank.addClient(nowak);
        bank.addClient(zieba);

        bank.removeClient("2222");

        assertEquals(2, bank.getClientCount());

    }
    @Test
    void shouldReturnTrueWhenAccountNrExistAndDeposit() {

        Client[] clients = new Client[0];
        Bank bank = new Bank(clients);
        Client nowak = new Client("Nowak", "8985", 10);
        Client zieba = new Client("Zięba", "4205", 700);
        bank.addClient(nowak);
        bank.addClient(zieba);

        boolean isTrue =  bank.deposit("8985",500);

        assertEquals(true, isTrue);
        assertEquals(510,nowak.getBalance());

    }
    @Test
    void shouldReturnTrueWhenAccountsExistAndTransfer() {

        Client[] clients = new Client[0];
        Bank bank = new Bank(clients);
        Client nowak = new Client("Nowak", "8985", 10);
        Client zieba = new Client("Zięba", "4205", 700);
        bank.addClient(nowak);
        bank.addClient(zieba);

        boolean isTrue =  bank.transfer("8985","4205",5);

        assertEquals(true, isTrue);
        assertEquals(705,zieba.getBalance());
        assertEquals(5,nowak.getBalance());
    }

}