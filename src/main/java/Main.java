import com.joaosevergnini.viacepfinder.domain.model.Address;
import com.joaosevergnini.viacepfinder.service.ViaCepService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ViaCepService viaCepService = new ViaCepService();
        List<Address> addresses = new ArrayList<>();

        while (true) {
            System.out.print("Enter a postal code (or type 'exit' to finish): ");
            String postalCode = scanner.nextLine();

            if (postalCode.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                Address address = viaCepService.findAddressByPostalCode(postalCode);
                addresses.add(address);
                System.out.println("Address found: " + address);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            viaCepService.writeAddressJson(addresses, "addresses.json");
            System.out.println("Addresses saved to addresses.json");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Address lookup completed.");

        scanner.close();
    }
}
