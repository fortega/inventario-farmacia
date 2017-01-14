package cl.fortega.model;

import cl.fortega.model.Caja;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-12T18:57:39")
@StaticMetamodel(Movimiento.class)
public class Movimiento_ { 

    public static volatile SingularAttribute<Movimiento, Date> hora;
    public static volatile SingularAttribute<Movimiento, Short> nulo;
    public static volatile SingularAttribute<Movimiento, Integer> id;
    public static volatile SingularAttribute<Movimiento, Integer> cantidad;
    public static volatile SingularAttribute<Movimiento, Caja> caja;

}