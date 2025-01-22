package Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ve")
public class Ve {

    @Id
    @Column(name = "maVe")
    @EqualsAndHashCode.Include
    private String maVe;
    private LocalDateTime thoiGianDi;
    private LocalDateTime thoiGianDen;
    private String soGhe;
    private double giaVe;
    private LoaiVe loaiVe;
    private TrangThaiVe trangThaiVe;
    private String tenKhachHang;

    @ManyToOne
    @JoinColumn(name = "ga_tau_ma_ga_tau")
    private GaTau gaTau;


}
