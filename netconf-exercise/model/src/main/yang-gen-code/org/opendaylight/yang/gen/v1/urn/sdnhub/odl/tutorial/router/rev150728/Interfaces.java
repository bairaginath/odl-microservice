package org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>router</b>
 * <br>(Source path: <i>META-INF/yang/router.yang</i>):
 * <pre>
 * list interfaces {
 *     key "id"
 *     leaf id {
 *         type string;
 *     }
 *     leaf ip-address {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>router/interfaces</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.InterfacesBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.InterfacesBuilder
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.InterfacesKey
 *
 */
public interface Interfaces
    extends
    ChildOf<RouterData>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.Interfaces>,
    Identifiable<InterfacesKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:odl:tutorial:router",
        "2015-07-28", "interfaces").intern();

    java.lang.String getId();
    
    java.lang.String getIpAddress();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    InterfacesKey getKey();

}

