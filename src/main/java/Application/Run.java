package Application;

import DataGenerator.CaLamViecGenerator;
import DataGenerator.GaTauGenerator;
import DataGenerator.KhachHangGenerator;
import DataGenerator.NhanVienGenerator;
import Entities.CaLamViec;
import Entities.GaTau;
import Entities.KhachHang;
import Entities.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Run {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("maria-db");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        KhachHangGenerator khachHangGenerator = new KhachHangGenerator();
        for (int i = 0; i < 10; i++) {
            KhachHang kh = khachHangGenerator.khachHangGenerator();
            em.persist(kh);

            System.out.println("Khách hàng " + (i + 1) + ":");
            System.out.println("Mã khách hàng: " + kh.getMaKhachHang());
            System.out.println("Tên khách hàng: " + kh.getTenKhachHang());
            System.out.println("Số điện thoại: " + kh.getSoDienThoai());
            System.out.println("Ngày sinh: " + kh.getNgaySinh());
            System.out.println("Loại khách hàng: " + kh.getLoaiKhachHang());
            System.out.println("-----------------------------------");
        }

        NhanVienGenerator nhanVienGenerator = new NhanVienGenerator();
        for (int i = 0; i < 10; i++) {
            NhanVien nv = nhanVienGenerator.nhanVienGenerator();
            em.persist(nv);

            System.out.println("Nhân viên " + (i + 1) + ":");
            System.out.println("Mã nhân viên: " + nv.getMaNhanVien());
            System.out.println("Căn cước công dân: " + nv.getCCCD());
            System.out.println("Tên nhân viên: " + nv.getTenNhanVien());
            System.out.println("Địa chỉ: " + nv.getDiaChi());
            System.out.println("Số điện thoại: " + nv.getSoDienThoai());
            System.out.println("Loại nhân viên: " + nv.getLoaiNhanVien());
            System.out.println("Trạng thái nhân viên: " + nv.getTrangThaiNhanVien());
            System.out.println("-----------------------------------");
        }

        GaTauGenerator gaTauGenerator = new GaTauGenerator();
        for (int i = 0; i < 10; i++) {
            GaTau ga = gaTauGenerator.gaTauGenerator();
            em.persist(ga);

            System.out.println("Ga tàu " + (i + 1) + ":");
            System.out.println("Mã ga tàu: " + ga.getMaGaTau());
            System.out.println("Tên ga tàu: " + ga.getTenGaTau());
            System.out.println("Địa chỉ: " + ga.getDiaChi());
            System.out.println("-----------------------------------");
        }

        CaLamViecGenerator caLamViecGenerator = new CaLamViecGenerator();
        for (int i = 0; i < 10; i++) {
            CaLamViec caLamViec = caLamViecGenerator.caLamViecGenerator();
            em.persist(caLamViec);

            // Xuất thông tin ca làm việc và nhân viên
            System.out.println("Ca làm việc " + (i + 1) + ":");
            System.out.println("Mã ca làm việc: " + caLamViec.getMaCaLamViec());
            System.out.println("Thời gian bắt đầu: " + caLamViec.getThoiGianBatDat());
            System.out.println("Thời gian kết thúc: " + caLamViec.getThoiGianKetThuc());

            // Lấy thông tin nhân viên
            NhanVien nhanVien = caLamViec.getNhanVien();
            if (nhanVien != null) {
                System.out.println("Nhân viên:");
                System.out.println("  Mã nhân viên: " + nhanVien.getMaNhanVien());
                System.out.println("  Tên nhân viên: " + nhanVien.getTenNhanVien());
                System.out.println("  Địa chỉ: " + nhanVien.getDiaChi());
                System.out.println("  Số điện thoại: " + nhanVien.getSoDienThoai());
                System.out.println("  Loại nhân viên: " + nhanVien.getLoaiNhanVien());
                System.out.println("  Trạng thái: " + nhanVien.getTrangThaiNhanVien());
            } else {
                System.out.println("Nhân viên: Không có thông tin");
            }
            System.out.println("-----------------------------------");
        }

        em.getTransaction().commit();
        em.close();

    }

}
