package DataGenerator;

import Entities.*;
import net.datafaker.Faker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VeGenerator {

    private final Faker faker = new Faker();
    private final KhachHangGenerator khachHangGenerator = new KhachHangGenerator();
    private final GaTauGenerator gaTauGenerator = new GaTauGenerator();

    public Ve veGenerator() {
        Ve ve = new Ve();
        ve.setMaVe(faker.numerify("VE##########"));

        LocalDateTime thoiGianDi = LocalDateTime.now().plusMinutes(faker.number().numberBetween(1, 10000)); // Random thời gian đi trong 10000 phút
        ve.setThoiGianDi(thoiGianDi);

        LocalDateTime thoiGianDen = thoiGianDi.plusMinutes(faker.number().numberBetween(30, 1000)); // Thời gian đến ít nhất 30 phút sau thời gian đi
        ve.setThoiGianDen(thoiGianDen);

        String soGhe = String.format("%d", faker.number().numberBetween(1, 100)); // Ghế từ 1 đến 100
        ve.setSoGhe(soGhe);

        double giaVe = faker.number().randomDouble(2, 100000, 1000000); // Giá vé từ 100.000đ đến 1.000.000đ
        ve.setGiaVe(giaVe);

        LoaiVe[] loaiVeValues = LoaiVe.values();
        LoaiVe loaiVe = loaiVeValues[faker.number().numberBetween(0, loaiVeValues.length)];
        ve.setLoaiVe(loaiVe);

        TrangThaiVe[] trangThaiVeValues = TrangThaiVe.values();
        TrangThaiVe trangThaiVe = trangThaiVeValues[faker.number().numberBetween(0, trangThaiVeValues.length)];
        ve.setTrangThaiVe(trangThaiVe);

        GaTau gaTauDi = gaTauGenerator.gaTauGenerator();
        ve.setGaTau(gaTauDi);

        GaTau gaTauDen;
        do {
            gaTauDen = gaTauGenerator.gaTauGenerator();
        } while (gaTauDi.getMaGaTau().equals(gaTauDen.getMaGaTau()));

        ve.setGaTau(gaTauDen);


        // Lấy tên khách hàng và gán vào thuộc tính tenKhachHang của Ve
        String tenKhachHang = khachHangGenerator.khachHangGenerator().getTenKhachHang();
        ve.setTenKhachHang(tenKhachHang); // Chỉ gán tên khách hàng

        return ve;
    }

    public List<Ve> danhSachVe(int soLuong) {
        List<Ve> danhSach = new ArrayList<>();
        for (int i = 0; i < soLuong; i++) {
            danhSach.add(veGenerator());
        }
        return danhSach;
    }
}
