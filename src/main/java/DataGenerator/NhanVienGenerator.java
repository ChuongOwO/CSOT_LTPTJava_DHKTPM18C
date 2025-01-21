package DataGenerator;

import Entities.LoaiNhanVien;
import Entities.NhanVien;
import Entities.TrangThaiNhanVien;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NhanVienGenerator {

    private Faker faker = new Faker();
    private final Random rand = new Random();

    //Tao doi tuong nhan vien
    public NhanVien nhanVienGenerator() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNhanVien(faker.numerify("NV##########"));
        nhanVien.setCCCD("0" + faker.numerify("##########"));
        nhanVien.setTenNhanVien(faker.name().fullName());
        nhanVien.setDiaChi(faker.address().fullAddress());
        nhanVien.setSoDienThoai(faker.phoneNumber().cellPhone());
        nhanVien.setSoDienThoai(faker.internet().emailAddress());

        LoaiNhanVien loaiNhanVien = LoaiNhanVien.values()[rand.nextInt(LoaiNhanVien.values().length)];
        nhanVien.setLoaiNhanVien(loaiNhanVien);

        TrangThaiNhanVien trangThaiNhanVien = TrangThaiNhanVien.values()[rand.nextInt(TrangThaiNhanVien.values().length)];
        nhanVien.setTrangThaiNhanVien(trangThaiNhanVien);

        return nhanVien;
    }

}
