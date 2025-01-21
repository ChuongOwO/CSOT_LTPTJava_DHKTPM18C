package DataGenerator;

import Entities.GaTau;
import net.datafaker.Faker;

import java.util.Random;

public class GaTauGenerator {

    private Faker faker = new Faker();
    private final Random rand = new Random();

    //Tao doi tuong ga tau
    public GaTau gaTauGenerator() {
        GaTau gaTau = new GaTau();
        gaTau.setMaGaTau(faker.letterify("???").toUpperCase());
        gaTau.setTenGaTau(faker.address().cityName());
        gaTau.setDiaChi(faker.address().fullAddress());

        return gaTau;
    }
}
