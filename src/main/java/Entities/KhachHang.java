package Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "khachHang")
public class KhachHang {

    @Id
    @Column(name = "maKhachHang")
    @EqualsAndHashCode.Include
    private String maKhachHang;
    private String CCCD;
    private String tenKhachHang;
    private String soDienThoai;
    private LocalDate ngaySinh;

    @ManyToOne
    @JoinColumn(name = "maLoaiKhachHang") // Tên cột trong bảng khachhang
    private LoaiKhachHang loaiKhachHang;
}
