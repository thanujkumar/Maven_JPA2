package com.tk.annotation.inheritance.singletable_per_class_hierarchy.stratergy2;

import lombok.Data;

import javax.persistence.*;

/*
 * 
 * http://www.thejavageek.com/2014/05/14/jpa-single-table-inheritance-example/
 *
 * inheritence using <joined-subclass/>
 */

/**
 * 
 * <code> Entity Inheritance Mapping Strategies </code> </br>
 * You can configure how the Java Persistence provider maps inherited entities
 * to the underlying datastore by decorating the root class of the hierarchy
 * with the annotation javax.persistence.Inheritance. The following mapping
 * strategies are used to map the entity data to the underlying database:
 * <ol>
 * <li>A single table per class hierarchy
 * 
 * <li>A table per concrete entity class
 * 
 * <li>A <code>join</code> strategy, whereby fields or properties that are specific to a
 * subclass are mapped to a different table than the fields or properties that
 * are common to the parent class
 * </ol>
 * The strategy is configured by setting the strategy element of @Inheritance to
 * one of the options defined in the javax.persistence.InheritanceType
 * enumerated type:
 * 
 * <pre>
 * public enum InheritanceType {
 * 	SINGLE_TABLE, JOINED, TABLE_PER_CLASS
 * };
 * </pre>
 * 
 * The default strategy, InheritanceType.SINGLE_TABLE, is used if
 * the @Inheritance annotation is not specified on the root class of the entity
 * hierarchy.
 * </br>
 * <i> With this strategy, which corresponds to the default
 * InheritanceType.SINGLE_TABLE, all classes in the hierarchy are mapped to a
 * single table in the database. This table has a discriminator column
 * containing a value that identifies the subclass to which the instance
 * represented by the row belongs.
 */
@Entity
@Data
@Table(name = "VEHICLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "VEHICLE_TYPE", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class VehicleEntity {

	@Id
	@TableGenerator(name = "VEHICLE_GEN", table = "ID_GEN", pkColumnName = "GEN_NAME", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "VEHICLE_GEN")
	@Column(name = "VEHICLE_ID")
	private int vehicleId;

	@Column(name = "MANUFACTURER")
	private String manufacturer;
}
