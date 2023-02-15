package com.goit.feature;

import com.goit.feature.client.Client;
import com.goit.feature.client.ClientCrudService;
import com.goit.feature.database.DatabaseInitService;
import com.goit.feature.database.hibernate.HibernateUtil;
import com.goit.feature.planet.Planet;
import com.goit.feature.planet.PlanetCrudService;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        new DatabaseInitService().initDb();
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

        ClientCrudService clientCrudService = new ClientCrudService(session);
        PlanetCrudService planetCrudService = new PlanetCrudService(session);

        List<Client> existingClients = clientCrudService.getAllClients();
        long newClientAnn = clientCrudService.createNewClient("Ann");

        Client updateClient = clientCrudService.updateClientById(23, "Anatoliy");

        List<Client> newClientsList = clientCrudService.getAllClients();
        System.out.println(newClientsList);

        clientCrudService.deleteClientById(11L);

        planetCrudService.createNewPlanet("EAR2", "Earth2.0");

        Planet getPlanetById = planetCrudService.getPlanetById("ER");
        System.out.println("The planet with id: ER - " + getPlanetById.getName() );

        Planet updatePlanet = planetCrudService.updatePlanetById("EAR2", "Earth2.2");

        List<Planet> planetsList = planetCrudService.getAllPlanets();
        System.out.println(planetsList);

        planetCrudService.createNewPlanet("ZHY", "Zhytomyr");

        planetCrudService.deletePlanetById("ZHY");

        session.close();
    }
}
