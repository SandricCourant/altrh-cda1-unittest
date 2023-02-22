package org.example;

import org.example.controllers.ReservationController;
import org.example.controllers.VehiculeController;
import org.example.repositories.ReservationRepository;
import org.example.repositories.VehiculeCategoryRepository;
import org.example.repositories.VehiculeSubCategoryRepository;
import org.example.services.ReservationService;
import org.example.services.impl.ReservationServiceImpl;
import org.example.services.VehiculeService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static ReservationController bertrand;
    private static VehiculeController sandy;

    private static ReservationRepository sophie;
    private static ReservationService nicolas;
    private static VehiculeCategoryRepository maxime;
    private static VehiculeSubCategoryRepository theo;
    private static VehiculeService anna;

    private static void bootstrapContainer() {
        sophie = new ReservationRepository();
        nicolas = new ReservationServiceImpl(sophie);
        maxime = new VehiculeCategoryRepository();
        theo = new VehiculeSubCategoryRepository();
        anna = new VehiculeService(maxime, theo);
        bertrand = new ReservationController(nicolas, anna);
        sandy = new VehiculeController(anna);
    }

    private static int askForVehiculeCategoryIndex() {
        System.out.println(sandy.listVehiculeCategories());
        System.out.println("Choisir la categorie de véhicule : ");
        String saisie = scanner.nextLine();
        return Integer.parseInt(saisie);
    }

    private static void handleReservation() {
        int vehiculeCategoryIndex = askForVehiculeCategoryIndex();

        System.out.println(sandy.listVehiculeSubCategories(vehiculeCategoryIndex));
        System.out.println("Choisir la sous-categorie de ce véhicule : ");
        String saisie = scanner.nextLine();
        int vehiculeSubCategoryIndex = Integer.parseInt(saisie);

        System.out.println("Nom du client : ");
        String fullname = scanner.nextLine();
        System.out.println("Ville de départ : ");
        String departure = scanner.nextLine();
        System.out.println("Ville d'arrivée : ");
        String arrival = scanner.nextLine();
        System.out.println("Date et heure de début de réservation : ");
        String startAt = scanner.nextLine();
        System.out.println("Date et heure de fin de réservation : ");
        String endAt = scanner.nextLine();

        String details = bertrand.book(vehiculeCategoryIndex, vehiculeSubCategoryIndex, fullname, departure, arrival, startAt, endAt);
        System.out.println("Réservation faite : " + details);
    }

    private static void handleCancellation() {
        System.out.println("Quelle référence doit-on annuler ? ");
        String saisie = scanner.nextLine();
        int reference = Integer.parseInt(saisie);
        bertrand.cancel(reference);
        System.out.println("Réservation annulée !");
    }

    private static void handleVehiculeCategoryCreation() {
        System.out.println("Quel est le nom de la categorie a ajouter ?");
        String saisie = scanner.nextLine();
        sandy.createCategory(saisie);
        System.out.println("C'est créée !");
    }

    private static void handleVehiculeSubCategoryCreation() {
        int vehiculeCategoryIndex = askForVehiculeCategoryIndex();

        System.out.println("Quel est le nom de la sous categorie ?");
        String saisie = scanner.nextLine();
        sandy.createSubCategory(vehiculeCategoryIndex, saisie);
        System.out.println("C'est créée !");
    }

    private static void handleReservatinList() {
        int vehiculeCategoryIndex = askForVehiculeCategoryIndex();

        List<String> results = bertrand.list(vehiculeCategoryIndex);
        System.out.println("Voici la liste des réservations :");
        System.out.println(results);
    }

    private static void handleFindReservationByReference() {
        System.out.println("Quel est la reference à chercher ?");
        String saisie = scanner.nextLine();
        int reference = Integer.parseInt(saisie);
        String result = bertrand.findByReference(reference);
        System.out.println(result);

        System.out.println("Quel souhaitez vous faire ? ('r' retour, 'a' annuler, 'm' modifier)");
        saisie = scanner.nextLine();
        if (saisie.equals("a")) {
            bertrand.cancel(reference);
        } else if (saisie.equals("m")) {
            partChangeClient(reference);
        }
    }

    private static void handleChangeClient() {
        System.out.println("Quel est la reference de la reservation à changer ?");
        String saisie = scanner.nextLine();
        int reference = Integer.parseInt(saisie);
        partChangeClient(reference);
    }

    private static void partChangeClient(int reference) {
        System.out.println("Quel est le nouveau nom du client ?");
        String saisie = scanner.nextLine();

        boolean result = bertrand.changeReservationClient(reference, saisie);
        if (result == true) {
            System.out.println("La reservation a été mis à jour");
        } else {
            System.out.println("Impossible de changer le nom");
        }
    }

    public static void main(String[] args) {
        bootstrapContainer();

        System.out.println("Bienvenue dans le logiciel de reservation");
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Que souhaitez-vous faire ? ('r' reserver, 'c' cencel, 't' create category, 's' create sub category, 'l' list reservations, 'f' find reservation)");
            String saisie = scanner.nextLine();
            if (saisie.equals("r")) {
                handleReservation();
            } else if(saisie.equals("c")) {
                handleCancellation();
            } else if(saisie.equals("t")) {
                handleVehiculeCategoryCreation();
            } else if(saisie.equals("s")) {
                handleVehiculeSubCategoryCreation();
            } else if(saisie.equals("l")) {
                handleReservatinList();
            } else if(saisie.equals("f")) {
                handleFindReservationByReference();
            } else if(saisie.equals("n")) {
                handleChangeClient();
            }
        }

    }
}