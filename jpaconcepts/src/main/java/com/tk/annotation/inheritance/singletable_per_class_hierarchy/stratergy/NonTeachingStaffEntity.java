package com.tk.annotation.inheritance.singletable_per_class_hierarchy.stratergy;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "NS")
@Data
@EqualsAndHashCode(callSuper=true)
public class NonTeachingStaffEntity extends StaffEntity {

	private String areaExpertise;
	
	public NonTeachingStaffEntity(Long sid, String name, String areaExpertise) {
		super(sid, name);
		this.areaExpertise = areaExpertise;
	}
}
