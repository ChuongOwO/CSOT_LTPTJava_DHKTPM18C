package Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "hoaDon")
public class HoaDon {

    @Id
    @Column(name = "maHoaDonBanVe")
    @EqualsAndHashCode.Include
    private String maHoaDonBanVe;
    private LocalDateTime thoiGianLap;
    @ManyToOne
    @JoinColumn(name = "khach_hang_mua_ve_ma_khach_hang")
    private KhachHang khachHangMuaVe;
    @ManyToOne
    @JoinColumn(name = "ca_lam_viec_ma_ca_lam_viec")
    private CaLamViec caLamViec;
}
