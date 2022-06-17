package juddi;

import org.uddi.api_v3.ServiceInfos;
import org.uddi.api_v3.ServiceList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("publish or browse? (default quit)");
            String publishOrBrowse = input.nextLine().trim();

            switch (publishOrBrowse) {
                case "publish":
                    SimplePublishPortable publishPortable = new SimplePublishPortable();
                    System.out.println("Publishing a service for a business.");
                    System.out.println("Enter business name, service name and service location (separated by commas).");
                    String[] dataArr = input.nextLine().trim().split(", ");
                    publishPortable.publish(dataArr[0], dataArr[1], dataArr[2]);
                    break;
                case "browse":
                    SimpleBrowse simpleBrowse = new SimpleBrowse();
                    System.out.println("Searching for service by name.");
                    System.out.println("Enter service name.");
                    String data = input.nextLine().trim();
                    System.out.println("Input: " + data);
                    ServiceList service = simpleBrowse.GetServiceByName(data);
                    ServiceInfos serviceInfo = service.getServiceInfos();
                    try {
                        serviceInfo.getServiceInfo().forEach(info -> {
                            System.out.println("Service name: " + info.getName().get(0).getValue());
                            System.out.println("Service key: " + info.getServiceKey());
                            System.out.println("Business key: " + info.getBusinessKey());
                        });
                    } catch (NullPointerException exc) {
                        System.out.println("No services with this name found!");
                    }
                    break;
                default:
                    return;
            }
        }
    }
}
