package DataGenerator;

import Entities.CaLamViec;
import Entities.NhanVien;
import net.datafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaLamViecGenerator {

    private final Faker faker = new Faker();
    private final Random rand = new Random();
    private final NhanVienGenerator nhanVienGenerator = new NhanVienGenerator();

    // Tạo một đối tượng ca làm việc
    public CaLamViec caLamViecGenerator() {
        CaLamViec caLamViec = new CaLamViec();

        // Lấy thời gian hiện tại và random ngày
        LocalDateTime now = LocalDateTime.now();
        int randomDays = rand.nextInt(30) - 15; // Random từ -15 đến +15 ngày
        LocalDateTime randomDate = now.plusDays(randomDays);
        String date = randomDate.format(DateTimeFormatter.ofPattern("ddMMyy")); // Ngày tháng năm: ddMMyy

        // Random mã ca làm việc (P01: sáng, P02: chiều, P03: tối)
        int shift = rand.nextInt(3) + 1; // Random 1, 2, hoặc 3
        String shiftCode = String.format("P%02d", shift); // Tạo shiftCode dạng "P01", "P02", "P03"

        // Thêm một thành phần ngẫu nhiên vào mã ca làm việc
        int randomSuffix = rand.nextInt(1000); // Random từ 0 đến 999
        String maCaLamViec = String.format("CLV%s%s%03d", date, shiftCode, randomSuffix); // Ví dụ: CLV220123P01001
        caLamViec.setMaCaLamViec(maCaLamViec);

        // Xác định thời gian bắt đầu và kết thúc
        LocalDateTime thoiGianBatDat = getThoiGianBatDau(randomDate, shift);
        LocalDateTime thoiGianKetThuc = thoiGianBatDat.plusHours(8); // Kết thúc sau 8 giờ
        caLamViec.setThoiGianBatDat(thoiGianBatDat);
        caLamViec.setThoiGianKetThuc(thoiGianKetThuc);

        // Gán một nhân viên bất kỳ (giả định)
        NhanVien nhanVien = nhanVienGenerator.nhanVienGenerator();
        caLamViec.setNhanVien(nhanVien);

        return caLamViec;
    }


    // Hàm lấy thời gian bắt đầu dựa trên ca làm việc và ngày random
    private LocalDateTime getThoiGianBatDau(LocalDateTime date, int shift) {
        if (shift == 1) {
            return date.withHour(6).withMinute(0).withSecond(0).withNano(0); // Ca sáng bắt đầu lúc 6h
        } else if (shift == 2) {
            return date.withHour(14).withMinute(0).withSecond(0).withNano(0); // Ca chiều bắt đầu lúc 14h
        } else {
            return date.withHour(22).withMinute(0).withSecond(0).withNano(0); // Ca tối bắt đầu lúc 22h
        }
    }

    // Tạo danh sách nhiều ca làm việc
    public List<CaLamViec> danhSachCaLamViec(int soLuong) {
        List<CaLamViec> danhSach = new ArrayList<>();
        for (int i = 0; i < soLuong; i++) {
            danhSach.add(caLamViecGenerator());
        }
        return danhSach;
    }
}
