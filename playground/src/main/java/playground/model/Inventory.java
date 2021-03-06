package playground.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import playground.base.AuditAndOptimisticField;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The persistent class for the INVENTORIES database table.
 * This table has composite primary key (also FK) to product_id and warehouse_id
 * <p>
 * Inventory information has details of inventories of the product in warehouse
 */
@Data
@EqualsAndHashCode(doNotUseGetters = true)
@Entity
@Table(name = "INVENTORIES")
@NamedQuery(name = Inventory.QUERY_ALL, query = "SELECT i FROM Inventory i")
public class Inventory extends AuditAndOptimisticField implements Serializable {

    public static final String QUERY_ALL="Inventory.findAll";

    @EmbeddedId
    private InventoryPK id;

    @Column(nullable = false, precision = 8)
    private long quantity;

    //bi-directional many-to-one association to warehouse
    @ManyToOne(fetch = FetchType.LAZY) //Many inventories belongs to warehouse ////ManyToOne default JPA fetch is Eager
    @JoinColumn(name = "WAREHOUSE_ID", nullable = false, insertable = false, updatable = false)
    private Warehouse warehouse;

    //bi-directional many-to-one association to Product
    @ManyToOne(fetch = FetchType.LAZY)//Many products belong to inventory
    @JoinColumn(name = "PRODUCT_ID", nullable = false, insertable = false, updatable = false)
    private Product product;
}
