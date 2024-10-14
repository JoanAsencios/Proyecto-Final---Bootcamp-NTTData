package com.microservice.client;

import com.microservice.client.AccountClient.AccountClient;
import com.microservice.client.dao.ClientDao;
import com.microservice.client.model.Client;
import com.microservice.client.services.ClientService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    ClientDao clientDao;

    @Mock
    AccountClient accountClient;

    @InjectMocks
    ClientService clientService;

    Client client = new Client();
    Client clientExpected = new Client();
    Client clientUp = new Client();
    ArrayList<Client> clientList = new ArrayList<>();

    @BeforeEach
    void setUp(){
        //Objeto Cliente
        client.setId(1);
        client.setDni("56534349");
        client.setNombres("Joan");
        client.setApellidos("Pruebas");
        client.setEmail("jpruebas@nttdata.com");
        //Objeto Esperado
        clientExpected.setId(1);
        clientExpected.setDni("56534349");
        clientExpected.setNombres("Joan");
        clientExpected.setApellidos("Pruebas");
        clientExpected.setEmail("jpruebas@nttdata.com");
        //Objeto Cliente actualizar
        clientUp.setId(1);
        clientUp.setNombres("Joan Kelvin");
        clientUp.setApellidos("Asencios Trujillo");
        clientUp.setDni("75646354");
        clientUp.setEmail("jasencio@nttdata.com");
        //Lista de clientes
        clientList.add(client);
        clientList.add(clientUp);
        clientList.add(clientExpected);
    }

    @Test
    void register(){
        Mockito.when(clientDao.register(client))
                .thenReturn(clientExpected);

        final Client clientResult = clientService.register(client);

        Assertions.assertNotNull(clientResult);
        Assertions.assertEquals(clientExpected, clientResult);
        //Verificar cuantas veces se esta invocando el metodo
        Mockito.verify(clientDao, Mockito.times(1)).register(client);
    }

    @Test
    void searchById(){
        Mockito.when(clientDao.getById(client.getId()))
                .thenReturn(clientExpected);

        final Client clientResult = clientService.getById(client.getId());

        Assertions.assertNotNull(clientResult);
        Assertions.assertEquals(clientExpected, clientResult);
        //Verificar cuantas veces se esta invocando el metodo
        Mockito.verify(clientDao, Mockito.times(1)).getById(client.getId());
    }

    @Test
    void searchAll(){
        Mockito.when(clientDao.getAll())
                        .thenReturn(clientList);

        final ArrayList<Client> listResult = clientService.getAll();

        Assertions.assertNotNull(listResult);
        Assertions.assertEquals(clientList, listResult);
        //Verificar cuantas veces se esta invocando el metodo
        Mockito.verify(clientDao, Mockito.times(1)).getAll();
    }

    @Test
    void update(){
        Mockito.when(clientDao.update(clientUp))
                .thenReturn(clientExpected);

        final Client clientResult = clientService.update(clientUp);

        Assertions.assertNotNull(clientResult);
        Assertions.assertEquals(clientExpected, clientResult);
        //Verificar cuantas veces se esta invocando el metodo
        Mockito.verify(clientDao, Mockito.times(1)).update(clientUp);
    }

    @Test
    void delete(){
        Mockito.doNothing().when(clientDao).delete(client.getId());

        clientService.delete(client.getId());
        //Verificar cuantas veces se esta invocando el metodo
        Mockito.verify(clientDao, Mockito.times(1)).delete(client.getId());
    }

}
