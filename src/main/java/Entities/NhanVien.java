package Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "khachhang")
public class NhanVien {

    @Id
    @Column(name = "maNhanVien")
    @EqualsAndHashCode.Include
    private String maNhanVien;
    private String CCCD;
    private String tenNhanVien;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private LoaiNhanVien loaiNhanVien;
    private TrangThaiNhanVien trangThaiNhanVien;
}
