package mx.mariovaldez.codechallenge.polizascoppel.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "inventory")
public class Inventory {

    @Id
    @Column(name = "SKU", length = 50, nullable = false)
    private String SKU;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @OneToOne(mappedBy = "inventory")
    private Policies policies;

}
