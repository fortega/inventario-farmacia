package cl.fortega.model;

import cl.fortega.model.Caja;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-12T18:57:39")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Short> nulo;
    public static volatile SingularAttribute<Item, Integer> id;
    public static volatile CollectionAttribute<Item, Caja> cajaCollection;
    public static volatile SingularAttribute<Item, String> nombre;

}