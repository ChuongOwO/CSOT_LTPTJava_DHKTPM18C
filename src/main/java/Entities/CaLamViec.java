package Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "caLamViec")
public class CaLamViec {

    @Id
    @Column(name = "maCaLamViec")
    @EqualsAndHashCode.Include
    private String maCaLamViec;
    private LocalDateTime thoiGianBatDat;
    private LocalDateTime thoiGianKetThuc;
    @ManyToOne
    @JoinColumn(name = "nhan_vien_ma_nhan_vien")
    private NhanVien nhanVien;
}
