package Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "gaTau")
public class GaTau {

    @Id
    @Column(name = "maGaTau")
    @EqualsAndHashCode.Include
    private String maGaTau;
    private String tenGaTau;
    private String diaChi;
}
