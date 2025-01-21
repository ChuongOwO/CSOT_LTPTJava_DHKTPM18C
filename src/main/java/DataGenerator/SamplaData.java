//package DataGenerator;
//
//import Entities.KhachHang;
//import Entities.NhanVien;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//public class SamplaData {
//    public void generateAndPrintSampleData() {
//        EntityManager em = Persistence
//                .createEntityManagerFactory("mariadb-pu")
//                .createEntityManager();
//
//        EntityTransaction tr = em.getTransaction();
//
//        KhachHangGenerator khachHangGenerator = new KhachHangGenerator();
//        NhanVienGenerator nhanVienGenerator = new NhanVienGenerator();
//
//
//        for (int i = 0; i < 15; i++) {
//            NhanVien nhanVien = khachHangGenerator();
//            KhachHang khachHang = nhanVienGenerator();
//            tr.begin();
//            em.persist(nhanVien.getMaNhanVien());
//            em.persist(khachHang.getMaKhachHang());
//            em.persist(nhanVien);
//            em.persist(khachHang);
//            tr.commit();
//        }
//    }
//
//    private KhachHang nhanVienGenerator() {
//        return new KhachHang();
//    }
//
//    private NhanVien khachHangGenerator() {
//        return new NhanVien();
//    }
//
////    public static void main(String[] args) {
////        SamplaData generator = new SamplaData();
////        generator.generateAndPrintSampleData();
////    }
//
//}
