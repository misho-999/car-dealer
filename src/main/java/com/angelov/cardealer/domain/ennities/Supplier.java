package com.angelov.cardealer.domain.ennities;

import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity{

   private String name;
   private boolean isImporter;
   private List<Part> parts;

   public Supplier() {
   }

   @Column(name = "name")
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Column(name = "is_importer")
   public boolean isImporter() {
      return isImporter;
   }

   public void setImporter(boolean importer) {
      isImporter = importer;
   }

   @OneToMany(targetEntity = Part.class, mappedBy = "supplier", fetch = FetchType.EAGER)
   public List<Part> getParts() {
      return parts;
   }

   public void setParts(List<Part> parts) {
      this.parts = parts;
   }
}
