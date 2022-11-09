package config;

public class TestConfig {

    protected final static String GET_RECEIPT_EXPECTED = "(==== black bun ====)\r\n" +
            "= filling cutlet =\r\n" +
            "(==== black bun ====)\r\n" +
            "\r\n" +
            "Price: 200,000000\r\n";

    protected final static String REMOVE_INGREDIENT_EXPECTED = "(==== black bun ====)\r\n" +
            "= filling dinosaur =\r\n" +
            "= filling cutlet =\r\n" +
            "= filling sausage =\r\n" +
            "(==== black bun ====)\r\n" +
            "\r\n" +
            "Price: 800,000000\r\n";

    protected final static String MOVE_INGREDIENT_EXPECTED = "(==== black bun ====)\r\n" +
            "= filling dinosaur =\r\n" +
            "= sauce sour cream =\r\n" +
            "(==== black bun ====)\r\n" +
            "\r\n" +
            "Price: 600,000000\r\n";

    protected final static float GET_PRICE_EXPECTED = 700f;
}