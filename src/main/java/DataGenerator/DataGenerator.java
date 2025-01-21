package DataGenerator;

import Entities.CaLamViec;
import Entities.GaTau;
import Entities.KhachHang;
import Entities.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DataGenerator {

    private final KhachHangGenerator khachHangGenerator = new KhachHangGenerator();
    private final NhanVienGenerator nhanVienGenerator = new NhanVienGenerator();
    private final GaTauGenerator gaTauGenerator = new GaTauGenerator();
    private final CaLamViecGenerator caLamViecGenerator = new CaLamViecGenerator();

    public void generateAndPersistData() {
        EntityManager em = Persistence.createEntityManagerFactory("maria-db").createEntityManager();
        EntityTransaction tr = em.getTransaction();

        for (int i = 0; i < 15; i++) {
            KhachHang khachHang = khachHangGenerator.khachHangGenerator();
            NhanVien nhanVien = nhanVienGenerator.nhanVienGenerator();
            GaTau gaTau = gaTauGenerator.gaTauGenerator();
            CaLamViec caLamViec = caLamViecGenerator.caLamViecGenerator();

            tr.begin();
            em.persist(khachHang);
            em.persist(nhanVien);
            em.persist(gaTau);
            em.persist(caLamViec);
            tr.commit();

            System.out.println("Persisted KhachHang: " + khachHang.getMaKhachHang());
            System.out.println("Persisted NhanVien: " + nhanVien.getMaNhanVien());
            System.out.println("Persisted GaTau: " + gaTau.getMaGaTau());
            System.out.println("Persisted CaLamViec: " + gaTau.getMaGaTau());
        }

        em.close();
    }

    public static void main(String[] args) {
        DataGenerator generator = new DataGenerator();
        generator.generateAndPersistData();
    }
}
