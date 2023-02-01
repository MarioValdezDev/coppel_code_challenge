package mx.mariovaldez.codechallenge.polizascoppel.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "policies")
public class Policies {

    @Id
    @Column(name = "idPolice", length = 50, nullable = false, unique = true)
    private String idPolice;

    @ManyToOne()
    @JoinColumn(name = "idEmployee")
    @JsonBackReference
    private Employee employee;

    @ManyToOne()
    @JoinColumn(name = "SKU")
    @JsonBackReference
    private Inventory inventory;

    @Column(name = "quantity", length = 50, nullable = false)
    private Integer quantity;

    @Column(name = "date", length = 50, nullable = false)
    private String date;

}
