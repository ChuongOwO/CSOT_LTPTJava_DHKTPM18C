package Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "loaikhachhang")
public class LoaiKhachHang {

    @Id
    @Column(name = "maLoaiKhachHang")
    private String maLoaiKhachHang;

    @Column(name = "tenLoaiKhachHang")
    private String tenLoaiKhachHang;

    @Column(name = "phanTramGiamGia")
    private double phanTramGiamGia;

    public LoaiKhachHang() {}

    public LoaiKhachHang(String maLoaiKhachHang, String tenLoaiKhachHang, double phanTramGiamGia) {
        this.maLoaiKhachHang = maLoaiKhachHang;
        this.tenLoaiKhachHang = tenLoaiKhachHang;
        this.phanTramGiamGia = phanTramGiamGia;
    }
}
