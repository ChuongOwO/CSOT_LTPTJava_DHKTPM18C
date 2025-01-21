package DataGenerator;

import Entities.KhachHang;
import Entities.LoaiKhachHang;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class KhachHangGenerator {

    private Faker faker = new Faker();
    private final Random rand = new Random();

    //Tao doi tuong khach hang
    public KhachHang khachHangGenerator() {
        KhachHang khachHang = new KhachHang();
        khachHang.setMaKhachHang(faker.numerify("KH##########"));
        khachHang.setCCCD(faker.numerify("############"));
        khachHang.setTenKhachHang(faker.name().fullName());
        khachHang.setSoDienThoai("0" + faker.numerify("##########"));

        int year = rand.nextInt(126) + 1900; // Tạo năm ngẫu nhiên từ 1900 đến 2025
        int month = rand.nextInt(12) + 1; // Tạo tháng ngẫu nhiên từ 1 đến 12
        int day = rand.nextInt(28) + 1; // Tạo ngày ngẫu nhiên từ 1 đến 28 (đảm bảo tính hợp lệ cho mọi tháng)
        LocalDate birthDate = LocalDate.of(year, month, day);

        khachHang.setNgaySinh(birthDate);

        List<LoaiKhachHang> loaiKhachHangOptions = Arrays.asList(
                new LoaiKhachHang("CT", "Người cao tuổi", 10.0),
                new LoaiKhachHang("HS", "Học sinh", 15.0),
                new LoaiKhachHang("TB", "Thương binh", 5.0),
                new LoaiKhachHang("TE", "Trẻ em", 20.0),
                new LoaiKhachHang("TT", "Thông thường", 25.0)
        );

        // Chọn ngẫu nhiên một đối tượng LoaiKhachHang từ danh sách
        LoaiKhachHang loaiKhachHang = loaiKhachHangOptions.get(rand.nextInt(loaiKhachHangOptions.size()));
        khachHang.setLoaiKhachHang(loaiKhachHang);
        return khachHang;
    }

}
