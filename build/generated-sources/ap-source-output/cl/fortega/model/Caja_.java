package cl.fortega.model;

import cl.fortega.model.Item;
import cl.fortega.model.Movimiento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-16T14:07:22")
@StaticMetamodel(Caja.class)
public class Caja_ { 

    public static volatile SingularAttribute<Caja, Item> item;
    public static volatile CollectionAttribute<Caja, Movimiento> movimientoCollection;
    public static volatile SingularAttribute<Caja, Integer> id;
    public static volatile SingularAttribute<Caja, Integer> cantidad;

}