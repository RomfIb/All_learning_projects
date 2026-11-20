//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Status status = new Status();
        EnumStatus status = EnumStatus.INITIALISED;
        System.out.println(status.getClass());
        BusinessFlow businessFlow = new BusinessFlow();
        businessFlow.status = EnumStatus.INITIALISED;
        System.out.println(businessFlow.status == EnumStatus.INITIALISED);

        for (EnumStatus stat : EnumStatus.values()) {
            System.out.println(stat);
        }
        EnumStatus stat2 = EnumStatus.valueOf("CREATED");
        System.out.println(stat2);
//        EnumStatus stat3 = EnumStatus.valueOf("Created");
//        System.out.println(stat3);
        System.out.println(stat2.name());
        System.out.println(EnumStatus.CREATED.ordinal());

        EnumWithValue enumWithValue = EnumWithValue.WOMAN;
        System.out.println(enumWithValue.getHeight());
        System.out.println(enumWithValue.calculateWeight(185));

        double priceAfterDiscount = ClientStatus.SILVER.calculateDiscount(1000.0);
        System.out.println(priceAfterDiscount);

        String message =
                switch (status) {
                    case CREATED -> "Status is created";
                    case INITIALISED -> "Status is initialised";
                    case CANCELLED -> "Status is cancelled";
                    case CONFORMED -> "Status is confirmed";
                };
        System.out.println(message);

        String message2 = " ";
        switch (status) {
            case CREATED :
                message2 = "Status is created";
                break;
            case CONFORMED:
                message2 = "Status is conformed";
                break;
            case CANCELLED:
                message2 = "Status is cancelled";
                break;
            case INITIALISED:
                message2 = "Status is initialised";
                break;
        }
        System.out.println(message2);

        Mountain mountain = new Mountain("Himalays", 6000, 3000);
        System.out.println(mountain);
        System.out.println(mountain.name());

    }
}